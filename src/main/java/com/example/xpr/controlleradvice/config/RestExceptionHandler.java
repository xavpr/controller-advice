package com.example.xpr.controlleradvice.config;

import com.example.xpr.controlleradvice.exception.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.auth.message.AuthException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.xpr.controlleradvice.exception.ErrorType.*;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
        return new ResponseEntity(ErrorResponse.builder().errorType(INTERNAL_ERROR).message(e.getMessage()).build(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthException.class)
    protected ResponseEntity<Object> handleAuthException(Exception e, WebRequest request) {
        return new ResponseEntity(ErrorResponse.builder().errorType(AUTHORIZATION_ERROR).message(e.getMessage()).build(), UNAUTHORIZED);
    }

    @Override
    //Get from the list of methods to override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = Stream.of(ex.getBindingResult()).map(Errors::getFieldError)
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse("Bind exception error");

        return new ResponseEntity(ErrorResponse.builder().errorType(BIND_ERROR).message(message).build(), BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .sorted()
                .collect(Collectors.joining("; "));

        return new ResponseEntity(ErrorResponse.builder().errorType(VALIDATION_ERROR).message(message).build(), BAD_REQUEST);
    }
}
