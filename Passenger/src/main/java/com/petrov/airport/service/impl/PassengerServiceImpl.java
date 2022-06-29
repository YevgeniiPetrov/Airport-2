package com.petrov.airport.service.impl;

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

    @Override
    public ResponsePassengerDTO get(int id) {
        return passengerMapper.passengerToMap(passengerRepository.get(id).get());
    }
}
