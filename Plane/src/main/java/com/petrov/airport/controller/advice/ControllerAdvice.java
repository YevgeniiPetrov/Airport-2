package com.petrov.airport.controller.advice;

import org.springframework.http.ResponseEntity;

import javax.persistence.NoResultException;

public interface ControllerAdvice {
    ResponseEntity<String> handleNoResultException(NoResultException exception);
}
