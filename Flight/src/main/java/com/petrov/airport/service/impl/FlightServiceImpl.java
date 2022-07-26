package com.petrov.airport.service.impl;

import com.petrov.airport.dto.*;
import com.petrov.airport.dto.mapper.FlightMapper;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.repository.FlightRepository;
import com.petrov.airport.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;
    private FlightMapper flightMapper;
    private RestTemplate restTemplate;
    private ResponseCompleted responseCompleted;

    @Override
    public ResponseFlightDTO get(int id) {
        Optional<Flight> optionalFlight = flightRepository.get(id);
        return optionalFlight.map(ticket -> flightMapper.flightToMap(ticket)).orElse(null);
    }

    @Override
    public List<ResponseFlightDTO> getFlightsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Flight> flights = flightRepository.getAllBetweenDates(dateFrom, dateTo);
        return flightMapper.flightsToMap(flights);
    }

    @Override
    public ResponseCompleted delete(Flight flight) {
        flightRepository.delete(flight);
        return responseCompleted;
    }

    @Override
    public ResponseCompleted delete(RequestEntityDTO requestEntityDTO) {
        Flight flight = flightRepository.get(requestEntityDTO.getId()).get();
        Map<String, Integer> headers = new HashMap<>();
        headers.put("id", flight.getId());
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        restTemplate.exchange(
                "http://localhost:8082/tickets/delete/flight", HttpMethod.DELETE,
                httpEntity, responseCompleted.getClass());
        return delete(flight);
    }

    @Override
    public ResponseCompleted update(RequestFlightChangeDeparture requestFlightChangeDeparture) {
        Flight flight = flightRepository.get(requestFlightChangeDeparture.getId()).get();
        flight.setDeparture(requestFlightChangeDeparture.getDeparture());
        flightRepository.update(flight);
        return responseCompleted;
    }

    @Override
    public List<ResponseFlightDTO> getAllByTerminal(int id) {
        return getForEntity(
                "http://localhost:8084/terminal/flights/get?id=" + id,
                new ParameterizedTypeReference<List<Integer>>() {}).stream()
                .map(flightRepository::get)
                .map(Optional::get)
                .map(flightMapper::flightToMap)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseFlightWithAirlinesDTO getWithAirlines(int id) {
        return flightMapper.flightWithAirlinesToMap(flightRepository.getWithAirlines(id).get());
    }

    private <T> List<T> getForEntity(String url, ParameterizedTypeReference<List<T>> parameterizedTypeReference) {
        return restTemplate.exchange(url, HttpMethod.GET, null, parameterizedTypeReference).getBody();
    }
}
