package com.example.xpr.controlleradvice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorType {

    GUITAR_ID_NOT_FOUND(BAD_REQUEST, 400, "Guitar ID should not be null"),
    INTERNAL_ERROR(INTERNAL_SERVER_ERROR, 500, "Internal error message"),
    BIND_ERROR(BAD_REQUEST, 400, "Binding error"),

    VALIDATION_ERROR(BAD_REQUEST, 400, "Request validation failed"),
    AUTHORIZATION_ERROR(UNAUTHORIZED, 401, "Your are not authorized to perform this action");


    private final HttpStatus status;
    private final Integer code;
    private final String message;

}
