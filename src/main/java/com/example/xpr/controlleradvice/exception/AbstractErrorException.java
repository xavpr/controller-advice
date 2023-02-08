package com.example.xpr.controlleradvice.exception;

import lombok.Getter;


@Getter
public abstract class AbstractErrorException extends RuntimeException {

    public AbstractErrorException(final String message) {
        super(message);
    }

    public abstract ErrorType getErrorType();

}
