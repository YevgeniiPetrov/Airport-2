package com.petrov.airport.dao;

import com.petrov.airport.entity.Plane;

import java.util.Optional;

public interface PlaneDAO extends GenericDAO<Plane> {
    Optional<Plane> getWithAirline(int id);
}
