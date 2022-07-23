package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.ResponsePlaneWithAirlineDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface PlaneController {
    ResponsePlaneDTO get(@RequestParam int id);
    ResponsePlaneWithAirlineDTO getWithAirline(@RequestParam int id);
}
