package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.RouteDAO;
import com.petrov.airport.entity.Route;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class RouteDAOImpl implements RouteDAO {
    private DataBase<Route> dataBase;

    @Override
    public DataBase<Route> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Route> get(int id) {
        return dataBase.get(id, Route.class);
    }

    @Override
    public List<Route> getAll() {
        return dataBase.getAll(Route.class);
    }
}
