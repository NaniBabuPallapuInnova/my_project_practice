package com.docker.springwithdocker.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalLevelExceptionHandlerExample {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nullPointerException.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFound(OrderNotFoundException orderNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(orderNotFoundException.getMessage());
    }

    @ExceptionHandler(InternalError.class)
    public ResponseEntity<String> handlerInterError(InternalError internalError){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(internalError.getMessage());
    }
}
