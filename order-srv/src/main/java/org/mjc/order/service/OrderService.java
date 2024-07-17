package org.mjc.order.service;

import org.mjc.order.controller.dto.OrderRequestDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    public BigDecimal getTotalPrice(OrderRequestDto orderRequestDto) {
        return BigDecimal.ZERO;
    }



}
