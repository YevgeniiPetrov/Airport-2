package com.petrov.airport.service;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseFlightDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    ResponseFlightDTO get(int id);
    List<ResponseFlightDTO> getFlightsBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
    ResponseCompleted delete(RequestEntityDTO requestEntityDTO);
}
