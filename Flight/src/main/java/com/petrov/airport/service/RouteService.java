package com.petrov.airport.service;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseCompleted;

public interface RouteService {
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
}
