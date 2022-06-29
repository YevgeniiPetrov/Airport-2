package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.ResponsePassengerDTO;
import com.petrov.airport.dto.impl.ResponsePassengerDTOImpl;
import com.petrov.airport.dto.mapper.PassengerMapper;
import com.petrov.airport.entity.Passenger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
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
}
