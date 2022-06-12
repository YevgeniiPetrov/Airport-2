package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.impl.ResponseTicketDTOImpl;
import com.petrov.airport.dto.mapper.EntityMapper;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketMapperImpl implements TicketMapper {
    private EntityMapper entityMapper;

    @Override
    public ResponseTicketDTO ticketToMap(Ticket ticket) {
        return new ResponseTicketDTOImpl().builder()
                .id(ticket.getId())
                .creationDate(ticket.getCreationDate())
                .place(ticket.getPlace())
                .passenger(entityMapper.integerToMap(ticket.getPassenger()))
                .flight(entityMapper.integerToMap(ticket.getFlight()))
                .build();
    }

    @Override
    public Ticket mapToTicket(RequestTicketDTO requestTicketDTO) {
        return Ticket.builder()
                .creationDate(requestTicketDTO.getCreationDate())
                .place(requestTicketDTO.getPlace())
                .passenger(entityMapper.mapToInteger(requestTicketDTO.getPassenger()))
                .flight(entityMapper.mapToInteger(requestTicketDTO.getFlight()))
                .build();
    }
}
