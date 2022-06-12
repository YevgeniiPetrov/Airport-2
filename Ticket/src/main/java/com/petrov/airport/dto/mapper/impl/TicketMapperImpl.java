package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.impl.ResponseTicketDTOImpl;
import com.petrov.airport.dto.mapper.FlightMapper;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketMapperImpl implements TicketMapper {
    private FlightMapper flightMapper;

    @Override
    public ResponseTicketDTO ticketToMap(Ticket ticket) {
        return new ResponseTicketDTOImpl().builder()
                .id(ticket.getId())
                .creationDate(ticket.getCreationDate())
                .place(ticket.getPlace())
                .passenger(ticket.getPassengerId())
                .flight(flightMapper.flightToMap(ticket.getFlight()))
                .build();
    }

    @Override
    public Ticket mapToTicket(RequestTicketDTO requestTicketDTO) {
        return Ticket.builder()
                .creationDate(requestTicketDTO.getCreationDate())
                .place(requestTicketDTO.getPlace())
                .passengerId(requestTicketDTO.getPassenger().getId())
                .flightId(requestTicketDTO.getFlight().getId())
                .build();
    }
}
