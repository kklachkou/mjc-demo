package org.mjc.product.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.mjc.product.controller.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ProductService {

    @Value("classpath:products.json")
    Resource productsResource;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ProductDto> searchProducts(List<UUID> productIds) {
        return readProductsFromJson()
                .stream()
                .filter(product -> productIds.contains(product.getId()))
                .toList();
    }

    private List<ProductDto> readProductsFromJson() {
        try {
            return objectMapper.readValue(productsResource.getInputStream(), new TypeReference<>() {
            });
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("Failed to read products from JSON file", e);
        }
    }
}
