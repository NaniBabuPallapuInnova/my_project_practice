package com.example.insurance_project.exception;

import com.example.insurance_project.response.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpringBootExceptionHandler {

    @Autowired
    private ResponseStructure<String> responseStructure;

    @ExceptionHandler(value =IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> noIdFound(IdNotFoundException exception){

        responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
        responseStructure.setMsg(exception.getMsg());
        responseStructure.setData(null);

        return new ResponseEntity<ResponseStructure<String>>(responseStructure ,HttpStatus.valueOf(HttpStatus.NOT_FOUND.value()));

    }
}