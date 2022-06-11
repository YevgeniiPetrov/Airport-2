package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.TicketController;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TicketControllerImpl implements TicketController {
    private TicketService ticketService;

    @Override
    @GetMapping("/ticket/get/")
    public ResponseTicketDTO get(int id) {
        return ticketService.get(id);
    }
}
