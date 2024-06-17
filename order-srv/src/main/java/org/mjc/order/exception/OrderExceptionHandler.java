package org.mjc.order.exception;

import org.mjc.order.controller.dto.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.util.UUID;

@ControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<OrderResponseDto> handleOrderException(OrderException ex) {
        OrderResponseDto responseDto = OrderResponseDto.builder()
                .id(UUID.randomUUID())
                .status(OrderResponseDto.StatusEnum.FAILED)
                .totalPrice(BigDecimal.ZERO)
                .build();

        return ResponseEntity.badRequest().body(responseDto);
    }

}

