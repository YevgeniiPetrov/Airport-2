package com.petrov.airport.repository;

import com.petrov.airport.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends GenericRepository<Flight> {
    List<Flight> getAllBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
}
