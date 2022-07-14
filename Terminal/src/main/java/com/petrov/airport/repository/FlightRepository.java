package com.petrov.airport.repository;

import com.petrov.airport.entity.Flight;

import java.util.Optional;

public interface FlightRepository extends GenericRepository<Flight> {
    Optional<Flight> getWithTerminals(int id);
}
