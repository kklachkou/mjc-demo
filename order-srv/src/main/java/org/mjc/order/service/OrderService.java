package org.mjc.order.service;

import org.mjc.order.client.api.ProductApi;
import org.mjc.order.client.dto.ProductDto;
import org.mjc.order.client.dto.ProductSearchRequestDto;
import org.mjc.order.controller.dto.OrderRequestDto;
import org.mjc.order.controller.dto.OrderRequestItemsInnerDto;
import org.mjc.order.exception.OrderException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final ProductApi productApi = new ProductApi();

    public BigDecimal getTotalPrice(OrderRequestDto orderRequestDto) {

        var idsToRequest = orderRequestDto.getItems().stream().map(OrderRequestItemsInnerDto::getProductId).toList();
        var productSearchRequestDto = new ProductSearchRequestDto().productIds(idsToRequest);
        List<ProductDto> availableProducts = productApi.searchProducts(productSearchRequestDto).collectList().block();

        return orderRequestDto.getItems()
                .stream()
                .map(requestedItem -> getTotalPriceForQuantity(requestedItem, availableProducts))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPriceForQuantity(
            OrderRequestItemsInnerDto requestedItem,
            List<ProductDto> availableProducts) {

        return availableProducts
                .stream()
                .filter(p -> requestedItem.getProductId().equals(p.getId()))
                .filter(p -> requestedItem.getQuantity() <= p.getQuantity())
                .findFirst()
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(requestedItem.getQuantity())))
                .orElseThrow(() -> new OrderException("Cannot process order"));
    }

}
