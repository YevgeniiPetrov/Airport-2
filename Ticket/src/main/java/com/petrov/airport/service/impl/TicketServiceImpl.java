package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Ticket;
import com.petrov.airport.repository.TicketRepository;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private TicketMapper ticketMapper;

    @Override
    public ResponseTicketDTO get(int id) {
        Optional<Ticket> optionalTicket = ticketRepository.get(id);
        return optionalTicket.map(ticket -> ticketMapper.ticketToMap(ticket)).orElse(null);
    }
}
