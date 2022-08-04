package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.ResponseAirlineWithPlanesDTO;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.entity.Airline;
import com.petrov.airport.repository.AirlineRepository;
import com.petrov.airport.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public ResponseAirlineWithPlanesDTO getWithPlanes(int id) {
        return airlineMapper.airlineWithPlanesToMap(airlineRepository.getWithPlanes(id).get());
    }

    @Override
    public ResponseAirlineDTO getResponseAirlineDTO(int id) {
        return airlineMapper.airlineToMap(get(id));
    }
}
