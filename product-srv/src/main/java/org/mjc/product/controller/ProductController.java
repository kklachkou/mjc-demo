package org.mjc.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    public List<Object> searchProducts(Object productSearchRequestDto) {
        return List.of();
    }
}
