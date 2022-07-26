package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.dto.ResponseFlightWithAirlinesDTO;
import com.petrov.airport.dto.impl.ResponseFlightDTOImpl;
import com.petrov.airport.dto.impl.ResponseFlightWithAirlinesDTOIml;
import com.petrov.airport.dto.mapper.AirlineMapper;
import com.petrov.airport.dto.mapper.FlightMapper;
import com.petrov.airport.dto.mapper.RouteMapper;
import com.petrov.airport.dto.mapper.StateMapper;
import com.petrov.airport.entity.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FlightMapperImpl implements FlightMapper {
    private RouteMapper routeMapper;
    private StateMapper stateMapper;
    private AirlineMapper airlineMapper;

    @Override
    public ResponseFlightDTO flightToMap(Flight flight) {
        return ResponseFlightDTOImpl.builder()
                .id(flight.getId())
                .departure(flight.getDeparture())
                .duration(flight.getDuration())
                .route(routeMapper.routeToMap(flight.getRoute()))
                .state(stateMapper.stateToMap(flight.getState()))
                .build();
    }

    @Override
    public List<ResponseFlightDTO> flightsToMap(List<Flight> flights) {
        List<ResponseFlightDTO> flightDTOList = new ArrayList<>();
        flights.stream()
                .map(this::flightToMap)
                .forEach(flightDTOList::add);
        return flightDTOList;
    }

    @Override
    public Flight mapToFlight(RequestEntityDTO requestEntityDTO) {
        return Flight.builder()
                .id(requestEntityDTO.getId())
                .build();
    }

    @Override
    public ResponseFlightWithAirlinesDTO flightWithAirlinesToMap(Flight flight) {
        return ResponseFlightWithAirlinesDTOIml.builder()
                .id(flight.getId())
                .departure(flight.getDeparture())
                .duration(flight.getDuration())
                .route(routeMapper.routeToMap(flight.getRoute()))
                .state(stateMapper.stateToMap(flight.getState()))
                .airlines(flight.getAirlines().stream()
                        .map(airlineMapper::airlineToMap)
                        .collect(Collectors.toList()))
                .build();
    }
}
