package com.petrov.airport.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import javax.persistence.NoResultException;

public interface ControllerAdvice {
    ResponseEntity<String> handleNoResultException(NoResultException exception);
    String exception(final Throwable throwable, final Model model);
}
