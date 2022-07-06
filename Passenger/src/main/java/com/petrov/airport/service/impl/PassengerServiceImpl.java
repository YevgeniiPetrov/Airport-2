package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestPassengerDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePassengerDTO;
import com.petrov.airport.dto.mapper.PassengerMapper;
import com.petrov.airport.repository.PassengerRepository;
import com.petrov.airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;
    private PassengerMapper passengerMapper;
    private ResponseCompleted responseCompleted;

    @Override
    public ResponsePassengerDTO get(int id) {
        return passengerMapper.passengerToMap(passengerRepository.get(id).get());
    }

    @Override
    public ResponseCompleted add(RequestPassengerDTO requestPassengerDTO) {
        passengerRepository.add(passengerMapper.mapToPassenger(requestPassengerDTO));
        return responseCompleted;
    }
}
