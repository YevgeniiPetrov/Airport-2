package com.petrov.airport.repository;

import com.petrov.airport.entity.Terminal;

import java.util.Optional;

public interface TerminalRepository extends GenericRepository<Terminal> {
    Optional<Terminal> getWithFlights(int id);
}
