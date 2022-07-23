package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponseAirlineDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface AirlineController {
    ResponseAirlineDTO get(@RequestParam int id);
}
