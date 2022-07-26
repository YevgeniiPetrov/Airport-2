package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.FlightDAO;
import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.entity.Flight;
import com.petrov.airport.entity.Route;
import com.petrov.airport.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FlightRepositoryImpl implements FlightRepository {
    private FlightDAO flightDAO;

    @Override
    public GenericDAO<Flight> getGenericDAO() {
        return flightDAO;
    }

    @Override
    public List<Flight> getAllBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return flightDAO.getAllBetweenDates(dateFrom, dateTo);
    }

    @Override
    public List<Flight> getAllByRoute(Route route) {
        return flightDAO.getAllByRoute(route);
    }

    @Override
    public Optional<Flight> getWithAirlines(int id) {
        return flightDAO.getWithAirlines(id);
    }
}
