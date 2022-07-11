package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestTicketDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseTicketDTO;
import com.petrov.airport.dto.mapper.FlightMapper;
import com.petrov.airport.dto.mapper.TicketMapper;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Passenger;
import com.petrov.airport.entity.Ticket;
import com.petrov.airport.repository.TicketRepository;
import com.petrov.airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private TicketMapper ticketMapper;
    private FlightMapper flightMapper;
    private ResponseCompleted responseCompleted;
    private RestTemplate restTemplate;

    @Override
    public ResponseTicketDTO get(int id) {
        Ticket ticket = ticketRepository.get(id).get();
        return get(ticket);
    }

    @Override
    public ResponseTicketDTO get(Ticket ticket) {
        ResponseEntity<Flight> flightResponseEntity = restTemplate.getForEntity(
                "http://localhost:8081/flight/get/?id=" + ticket.getFlightId(), Flight.class);
        ResponseEntity<Passenger> passengerResponseEntity = restTemplate.getForEntity(
                "http://localhost:8083/passenger/get/?id=" + ticket.getPassengerId(), Passenger.class);
        ticket.setFlight(flightResponseEntity.getBody());
        ticket.setPassenger(passengerResponseEntity.getBody());
        return ticketMapper.ticketToMap(ticket);
    }

    @Override
    public ResponseCompleted add(RequestTicketDTO requestTicketDTO) {
        setTicketCreationDate(requestTicketDTO);
        ticketRepository.add(ticketMapper.mapToTicket(requestTicketDTO));
        return responseCompleted;
    }

    @Override
    public ResponseCompleted add(List<RequestTicketDTO> requestTicketDTOList) {
        requestTicketDTOList.forEach(this::add);
        return responseCompleted;
    }

    @Override
    public ResponseCompleted delete(RequestEntityDTO requestEntityDTO) {
        ticketRepository.delete(ticketMapper.mapToTicket(requestEntityDTO));
        return responseCompleted;
    }

    @Override
    public ResponseCompleted deleteAllByFlight(RequestEntityDTO requestEntityDTO) {
        ticketRepository.getAllByFlight(flightMapper.mapToFlight(requestEntityDTO))
                .forEach(ticketRepository::delete);
        return responseCompleted;
    }

    @Override
    public List<ResponseTicketDTO> getTicketsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Ticket> tickets = ticketRepository.getAllBetweenDates(dateFrom, dateTo);
        return tickets.stream()
                .map(this::get)
                .collect(Collectors.toList());
    }

    private void setTicketCreationDate(RequestTicketDTO requestTicketDTO) {
        requestTicketDTO.setCreationDate(LocalDateTime.now());
    }
}
