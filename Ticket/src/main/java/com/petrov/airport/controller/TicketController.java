package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponseTicketDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface TicketController {
    ResponseTicketDTO get(@RequestParam int id);
}
