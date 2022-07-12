package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseCompleted;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface RouteController {
    ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO);
}
