package com.rumay.garcia.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRecord> handleDefaultExceptions(Exception ex, WebRequest request){
        ErrorRecord mal = new ErrorRecord(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(mal, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorRecord> handleArithmeticException(ArithmeticException ex, WebRequest request){
        ErrorRecord mal = new ErrorRecord(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(mal, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ErrorResponse handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        return ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, ex.getMessage())
                .title("Model Not Found Exception")
                .type(URI.create(request.getDescription(false)))
                .property("extra1","extra-value")
                .property("extra2", "Error Response App Web 7383")
                .build();
    }

}
