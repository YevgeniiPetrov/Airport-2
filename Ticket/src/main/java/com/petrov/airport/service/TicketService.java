package com.petrov.airport.service;

import com.petrov.airport.dto.ResponseTicketDTO;

public interface TicketService {
    ResponseTicketDTO get(int id);
}
