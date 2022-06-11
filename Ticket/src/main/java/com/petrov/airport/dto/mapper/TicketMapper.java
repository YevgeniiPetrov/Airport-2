package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.entity.Ticket;

public interface TicketMapper {
    ResponseTicketDTO ticketToMap(Ticket ticket);
}
