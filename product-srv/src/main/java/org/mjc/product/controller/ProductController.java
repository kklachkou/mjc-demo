package org.mjc.product.controller;

import org.mjc.product.controller.dto.ProductDto;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController implements ProductApi {

    @Override
    public ProductDto getProduct(String id) {
        return ProductDto.builder()
                .id(UUID.fromString("35cd851f-2276-4b98-9ed5-a7af4f0811f7"))
                .name("Product 1")
                .quantity(1)
                .price(BigDecimal.ONE)
                .build();
    }

    @Override
    public List<ProductDto> getProducts() {
        return List.of(
                ProductDto.builder()
                        .id(UUID.fromString("35cd851f-2276-4b98-9ed5-a7af4f0811f7"))
                        .name("Product 1")
                        .quantity(1)
                        .price(BigDecimal.ONE)
                        .build(),
                ProductDto.builder()
                        .id(UUID.fromString("5c64e76a-0478-4c5c-bf1d-db1124adb787"))
                        .name("Product 2")
                        .quantity(2)
                        .price(new BigDecimal("2.00"))
                        .build(),
                ProductDto.builder()
                        .id(UUID.fromString("d1b3fc89-6b98-4c80-a9f4-6ff345d32e8e"))
                        .name("Product 3")
                        .quantity(3)
                        .price(new BigDecimal("3.00"))
                        .build(),
                ProductDto.builder()
                        .id(UUID.fromString("b2a1d7f9-af1a-4b45-9fd0-3f2f8a60a41b"))
                        .name("Product 4")
                        .quantity(4)
                        .price(new BigDecimal("4.00"))
                        .build(),
                ProductDto.builder()
                        .id(UUID.fromString("abdd9418-4ee0-4d69-ad08-632b0ca477c1"))
                        .name("Product 5")
                        .quantity(5)
                        .price(new BigDecimal("5.00"))
                        .build()
        );
    }
}
