package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestPassengerDTO;
import com.petrov.airport.dto.ResponsePassengerDTO;
import com.petrov.airport.dto.impl.ResponsePassengerDTOImpl;
import com.petrov.airport.dto.mapper.PassengerMapper;
import com.petrov.airport.entity.Passenger;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PassengerMapperImpl implements PassengerMapper {
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
}
