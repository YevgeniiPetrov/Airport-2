package com.petrov.airport.repository;

import com.petrov.airport.entity.Plane;

import java.util.Optional;

public interface PlaneRepository extends GenericRepository<Plane> {
    Optional<Plane> getWithAirline(int id);
}
