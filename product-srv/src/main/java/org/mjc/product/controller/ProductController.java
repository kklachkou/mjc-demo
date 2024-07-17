package org.mjc.product.controller;

import lombok.RequiredArgsConstructor;
import org.mjc.product.controller.dto.ProductDto;
import org.mjc.product.controller.dto.ProductSearchRequestDto;
import org.mjc.product.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public List<ProductDto> searchProducts(ProductSearchRequestDto productSearchRequestDto) {
        return productService.searchProducts(productSearchRequestDto.getProductIds());
    }
}
