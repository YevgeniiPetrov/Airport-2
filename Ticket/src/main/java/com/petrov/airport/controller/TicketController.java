package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface TicketController {
    ResponseTicketDTO get(@RequestParam int id);
    ResponseCompleted create(@RequestBody @Valid RequestTicketDTO requestTicketDTO);
}
