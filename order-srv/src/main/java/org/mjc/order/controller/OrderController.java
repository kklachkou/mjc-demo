package org.mjc.order.controller;

import lombok.RequiredArgsConstructor;
import org.mjc.order.controller.dto.OrderRequestDto;
import org.mjc.order.controller.dto.OrderResponseDto;
import org.mjc.order.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

        BigDecimal totalPrice = orderService.getTotalPrice(orderRequestDto); // conversion to model omitted

        return OrderResponseDto.builder()
                .id(UUID.randomUUID())
                .status(OrderResponseDto.StatusEnum.SUCCEEDED)
                .createdAt(LocalDateTime.now())
                .totalPrice(totalPrice)
                .build();
    }

}

