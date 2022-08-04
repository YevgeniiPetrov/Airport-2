package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.entity.Airline;
import com.petrov.airport.repository.AirlineRepository;
import com.petrov.airport.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService {
    public AirlineMapper airlineMapper;
    private RestTemplate restTemplate;
    private AirlineRepository airlineRepository;

    @Override
    public Airline get(int id) {
        ResponseEntity<Airline> airlineResponseEntity = restTemplate.getForEntity(
                "http://localhost:8081/airline/get/?id=" + id, Airline.class);
        return airlineResponseEntity.getBody();
    }

    @Override
    public Optional<Airline> getWithPlanes(int id) {
        return airlineRepository.getWithPlanes(id);
    }

    @Override
    public ResponseAirlineDTO getResponseAirlineDTO(int id) {
        return airlineMapper.airlineToMap(get(id));
    }
}
