package com.desafio.impostos.core.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private Integer status;
    private String error;
    private String message;
    LocalDateTime timestemp;

    public ErrorResponse(Integer status, String error, String message) {
        this.timestemp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
