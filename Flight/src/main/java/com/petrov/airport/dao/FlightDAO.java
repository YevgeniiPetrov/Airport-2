package com.petrov.airport.dao;

import com.petrov.airport.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightDAO extends GenericDAO<Flight> {
    List<Flight> getAllBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo);
}
