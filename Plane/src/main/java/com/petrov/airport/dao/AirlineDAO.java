package com.petrov.airport.dao;

import com.petrov.airport.entity.Airline;

import java.util.Optional;

public interface AirlineDAO extends GenericDAO<Airline> {
    Optional<Airline> getWithPlanes(int id);
}
