package org.mjc.order.exception;

import lombok.extern.slf4j.Slf4j;
import org.mjc.order.controller.dto.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@Slf4j
@ControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<OrderResponseDto> handleOrderException(OrderException e) {
        log.error(e.getMessage());

        return ResponseEntity.ok().body(
                OrderResponseDto.builder()
                        .id(UUID.randomUUID())
                        .status(OrderResponseDto.StatusEnum.FAILED)
                        .build());
    }

}

