package com.petrov.airport.controller.advice.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;

@ControllerAdvice
public class ControllerAdviceImpl implements com.petrov.airport.controller.advice.ControllerAdvice {
    @Override
    @ExceptionHandler
    public ResponseEntity<String> handleNoResultException(NoResultException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
