package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponsePassengerDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface PassengerController {
    ResponsePassengerDTO get(@RequestParam int id);
}
