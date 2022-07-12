package com.petrov.airport.service.impl;

import com.petrov.airport.dto.*;
import com.petrov.airport.dto.mapper.PassengerMapper;
import com.petrov.airport.entity.Passenger;
import com.petrov.airport.repository.PassengerRepository;
import com.petrov.airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;
    private PassengerMapper passengerMapper;
    private ResponseCompleted responseCompleted;
    private RestTemplate restTemplate;

    @Override
    public ResponsePassengerDTO get(int id) {
        return passengerMapper.passengerToMap(passengerRepository.get(id).get());
    }

    @Override
    public ResponseCompleted add(RequestPassengerDTO requestPassengerDTO) {
        passengerRepository.add(passengerMapper.mapToPassenger(requestPassengerDTO));
        return responseCompleted;
    }

    @Override
    public ResponseCompleted addTickets(RequestPassengerTicketsDTO requestPassengerTicketsDTO) {
        Optional<Passenger> optionalPassenger = passengerRepository.get(
                requestPassengerTicketsDTO.getPassenger().getId());
        List<RequestTicketDTO> requestTicketDTOList = passengerMapper.mapToMap(
                optionalPassenger.get(), requestPassengerTicketsDTO);
        return restTemplate.postForObject(
                "http://localhost:8082/tickets/create", requestTicketDTOList, responseCompleted.getClass());
    }

    @Override
    public ResponseCompleted delete(RequestEntityDTO requestEntityDTO) {
        Passenger passenger = passengerRepository.get(requestEntityDTO.getId()).get();
        passengerRepository.delete(passenger);
        return responseCompleted;
    }
}
