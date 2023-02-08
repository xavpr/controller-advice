package com.example.xpr.controlleradvice.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private final ErrorType errorType;
    private final String message;
}
