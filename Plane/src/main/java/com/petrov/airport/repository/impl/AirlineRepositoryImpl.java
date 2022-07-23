package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.AirlineDAO;
import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.entity.Airline;
import com.petrov.airport.repository.AirlineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AirlineRepositoryImpl implements AirlineRepository {
    private AirlineDAO airlineDAO;

    @Override
    public GenericDAO<Airline> getGenericDAO() {
        return airlineDAO;
    }

    @Override
    public Optional<Airline> getWithPlanes(int id) {
        return airlineDAO.getWithPlanes(id);
    }
}
