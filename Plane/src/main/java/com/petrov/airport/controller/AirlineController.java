package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponseEntityDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface AirlineController {
    ResponseEntityDTO get(@RequestParam int id);
}
