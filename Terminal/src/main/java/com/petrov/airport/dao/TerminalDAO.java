package com.petrov.airport.dao;

import com.petrov.airport.entity.Terminal;

import java.util.Optional;

public interface TerminalDAO extends GenericDAO<Terminal> {
    Optional<Terminal> getWithFlights(int id);
}
