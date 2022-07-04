package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.PassengerDAO;
import com.petrov.airport.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Getter
@AllArgsConstructor
public class PassengerDAOImpl implements PassengerDAO {
    private DataBase<Passenger> dataBase;


    @Override
    public Optional<Passenger> get(int id) {
        return dataBase.get(id, Passenger.class);
    }

    @Override
    public List<Passenger> getAll() {
        return dataBase.getAll(Passenger.class);
    }
}
