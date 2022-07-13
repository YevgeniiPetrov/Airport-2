package com.petrov.airport.dao;

import com.petrov.airport.entity.Flight;

import java.util.Optional;

public interface FlightDAO extends GenericDAO<Flight> {
    Optional<Flight> getWithTerminals(int id);
}
