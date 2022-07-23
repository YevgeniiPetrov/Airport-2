package com.petrov.airport.repository;

import com.petrov.airport.entity.Airline;

import java.util.Optional;

public interface AirlineRepository extends GenericRepository<Airline> {
    Optional<Airline> getWithPlanes(int id);
}
