package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.mapper.EntityMapper;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketMapperImpl implements TicketMapper {
    private ResponseTicketDTO responseTicketDTO;
    private EntityMapper entityMapper;

    @Override
    public ResponseTicketDTO ticketToMap(Ticket ticket) {
        responseTicketDTO.setId(ticket.getId());
        responseTicketDTO.setCreationDate(ticket.getCreationDate());
        responseTicketDTO.setPlace(ticket.getPlace());
        responseTicketDTO.setPassenger(entityMapper.integerToMap(ticket.getPassenger()));
        responseTicketDTO.setFlight(entityMapper.integerToMap(ticket.getFlight()));
        return responseTicketDTO;
    }
}
