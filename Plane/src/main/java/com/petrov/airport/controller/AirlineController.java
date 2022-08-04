package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.ResponseAirlineWithPlanesDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface AirlineController {
    ResponseAirlineDTO get(@RequestParam int id);
    ResponseAirlineWithPlanesDTO getWithPlanes(int id);
}
