package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.dto.mapper.FlightMapper;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.repository.FlightRepository;
import com.petrov.airport.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;
    private FlightMapper flightMapper;

    @Override
    public List<ResponseFlightDTO> getFlightsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Flight> flights = flightRepository.getAllBetweenDates(dateFrom, dateTo);
        return flightMapper.flightsToMap(flights);
    }
}
