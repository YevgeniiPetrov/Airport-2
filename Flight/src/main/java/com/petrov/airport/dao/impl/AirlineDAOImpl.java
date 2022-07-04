package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.AirlineDAO;
import com.petrov.airport.entity.Airline;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Getter
@AllArgsConstructor
public class AirlineDAOImpl implements AirlineDAO {
    private DataBase<Airline> dataBase;

    @Override
    public Optional<Airline> get(int id) {
        return dataBase.get(id, Airline.class);
    }

    @Override
    public List<Airline> getAll() {
        return dataBase.getAll(Airline.class);
    }
}
