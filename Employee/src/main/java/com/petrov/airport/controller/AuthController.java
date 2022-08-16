package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestAuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthController {
    ResponseEntity<?> authenticate(@RequestBody RequestAuthenticationDTO request);
    void logout(HttpServletRequest request, HttpServletResponse response);
}
