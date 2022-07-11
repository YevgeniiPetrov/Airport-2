package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.*;
import com.petrov.airport.dto.impl.ResponsePassengerDTOImpl;
import com.petrov.airport.dto.mapper.EntityMapper;
import com.petrov.airport.dto.mapper.PassengerMapper;
import com.petrov.airport.entity.Passenger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PassengerMapperImpl implements PassengerMapper {
    private EntityMapper entityMapper;

    @Override
    public ResponsePassengerDTO passengerToMap(Passenger passenger) {
        return ResponsePassengerDTOImpl.builder()
                .id(passenger.getId())
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .birthDate(passenger.getBirthDate())
                .build();
    }

    @Override
    public Passenger mapToPassenger(RequestPassengerDTO requestPassengerDTO) {
        return Passenger.builder()
                .firstName(requestPassengerDTO.getFirstName())
                .lastName(requestPassengerDTO.getLastName())
                .birthDate(requestPassengerDTO.getBirthDate())
                .passport(requestPassengerDTO.getPassport())
                .build();
    }

    @Override
    public List<RequestTicketDTO> mapToMap(Passenger passenger, RequestPassengerTicketsDTO requestPassengerTicketsDTO) {
        List<RequestTicketDTO> ticketDTOList = new ArrayList<>();
        for (RequestPassengerTicketDTO requestPassengerTicketDTO : requestPassengerTicketsDTO.getTickets()) {
            ticketDTOList.add(RequestTicketDTO.builder()
                    .place(requestPassengerTicketDTO.getPlace())
                    .passenger(entityMapper.integerToMap(passenger.getId()))
                    .flight(requestPassengerTicketDTO.getFlight())
                    .build());
        }
        return ticketDTOList;
    }
}
