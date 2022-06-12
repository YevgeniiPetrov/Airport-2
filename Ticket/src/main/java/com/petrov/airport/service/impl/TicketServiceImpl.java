package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Ticket;
import com.petrov.airport.repository.TicketRepository;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private TicketMapper ticketMapper;
    private ResponseCompleted responseCompleted;

    @Override
    public ResponseTicketDTO get(int id) {
        Optional<Ticket> optionalTicket = ticketRepository.get(id);
        return optionalTicket.map(ticket -> ticketMapper.ticketToMap(ticket)).orElse(null);
    }

    @Override
    public ResponseCompleted add(RequestTicketDTO requestTicketDTO) {
        setTicketCreationDate(requestTicketDTO);
        ticketRepository.add(ticketMapper.mapToTicket(requestTicketDTO));
        return responseCompleted;
    }

    private void setTicketCreationDate(RequestTicketDTO requestTicketDTO) {
        requestTicketDTO.setCreationDate(LocalDateTime.now());
    }
}
