package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.FlightDAO;
import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class FlightRepositoryImpl implements FlightRepository {
    private GenericDAO<Flight> genericDAO;
    private FlightDAO flightDAO;

    @Override
    public GenericDAO<Flight> getGenericDAO() {
        return genericDAO;
    }

    @Override
    public Optional<Flight> getWithTerminals(int id) {
        return flightDAO.getWithTerminals(id);
    }
}
