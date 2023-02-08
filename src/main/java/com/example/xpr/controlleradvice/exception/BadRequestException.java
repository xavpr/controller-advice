package com.example.xpr.controlleradvice.exception;


public class BadRequestException extends AbstractErrorException{

    private final ErrorType errorType;

    public BadRequestException(final ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    @Override
    public ErrorType getErrorType() {
        return errorType;
    }
}
