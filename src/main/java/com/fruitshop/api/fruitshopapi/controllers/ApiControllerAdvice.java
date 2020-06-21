package com.fruitshop.api.fruitshopapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class,RuntimeException.class})
    public ResponseEntity<Map<String,String>> handleValidation(Exception e){
        Map<String, String> errors = new HashMap<>();
        ResponseEntity<Map<String,String>> responseEntity;
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException methodArgumentNotValidException
                = (MethodArgumentNotValidException)e;
            methodArgumentNotValidException.getBindingResult().getFieldErrors()
                .forEach(o ->
                    errors.put(o.getField(),o.getDefaultMessage())
                );
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
        } else {
            responseEntity = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        }
        return responseEntity;
    }
}
