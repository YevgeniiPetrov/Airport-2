package com.petrov.airport.service;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;

public interface TicketService {
    ResponseTicketDTO get(int id);
    ResponseCompleted add(RequestTicketDTO requestTicketDTO);
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
    ResponseCompleted deleteAllByFlight(RequestEntityDTO requestEntityDTO);
}
