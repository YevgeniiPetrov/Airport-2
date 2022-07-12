package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.entity.Route;
import com.petrov.airport.repository.FlightRepository;
import com.petrov.airport.repository.RouteRepository;
import com.petrov.airport.service.FlightService;
import com.petrov.airport.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private FlightRepository flightRepository;
    private FlightService flightService;
    private ResponseCompleted responseCompleted;

    @Override
    public ResponseCompleted delete(RequestEntityDTO requestEntityDTO) {
        Route route = routeRepository.get(requestEntityDTO.getId()).get();
        flightRepository.getAllByRoute(route)
                .forEach(flightService::delete);
        routeRepository.delete(route);
        return responseCompleted;
    }
}
