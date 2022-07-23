package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.repository.AirlineRepository;
import com.petrov.airport.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService {
    private AirlineRepository airlineRepository;
    private AirlineMapper airlineMapper;

    @Override
    public ResponseAirlineDTO get(int id) {
        return airlineMapper.airlineToMap(airlineRepository.get(id).get());
    }
}
