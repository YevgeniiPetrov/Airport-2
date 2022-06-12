package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Ticket;
import com.petrov.airport.repository.TicketRepository;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private TicketMapper ticketMapper;
    private ResponseCompleted responseCompleted;
    private RestTemplate restTemplate;

    @Override
    public ResponseTicketDTO get(int id) {
        Ticket ticket = ticketRepository.get(id).get();
        ResponseEntity<Flight> flightResponseEntity = restTemplate.getForEntity(
                "http://localhost:8081/flight/get/?id=" + ticket.getFlightId(), Flight.class);
        ticket.setFlight(flightResponseEntity.getBody());
        return ticketMapper.ticketToMap(ticket);
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
