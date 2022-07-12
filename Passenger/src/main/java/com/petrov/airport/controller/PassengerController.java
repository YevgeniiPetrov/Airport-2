package com.petrov.airport.controller;

import com.petrov.airport.dto.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface PassengerController {
    ResponsePassengerDTO get(@RequestParam int id);
    ResponseCompleted create(@RequestBody @Valid RequestPassengerDTO requestPassengerDTO);
    ResponseCompleted createTickets(@RequestBody @Valid RequestPassengerTicketsDTO requestPassengerTicketsDTO);
    ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO);
}
