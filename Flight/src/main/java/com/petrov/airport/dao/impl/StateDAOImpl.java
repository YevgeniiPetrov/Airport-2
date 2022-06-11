package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.StateDAO;
import com.petrov.airport.entity.State;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class StateDAOImpl implements StateDAO {
    private DataBase<State> dataBase;

    @Override
    public DataBase<State> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<State> get(int id) {
        return dataBase.get(id, State.class);
    }

    @Override
    public List<State> getAll() {
        return dataBase.getAll(State.class);
    }
}
