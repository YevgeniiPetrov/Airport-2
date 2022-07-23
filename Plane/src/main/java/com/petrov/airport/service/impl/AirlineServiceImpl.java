package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponseEntityDTO;
import com.petrov.airport.dto.mapper.EntityMapper;
import com.petrov.airport.repository.AirlineRepository;
import com.petrov.airport.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService {
    private AirlineRepository airlineRepository;
    public EntityMapper entityMapper;

    @Override
    public ResponseEntityDTO get(int id) {
        return entityMapper.entityToMap(airlineRepository.get(id).get());
    }
}
