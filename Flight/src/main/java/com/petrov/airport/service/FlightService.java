package com.petrov.airport.service;

import com.petrov.airport.dto.ResponseFlightDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<ResponseFlightDTO> getFlightsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
}
