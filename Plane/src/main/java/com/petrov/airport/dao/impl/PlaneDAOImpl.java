package com.petrov.airport.dao.impl;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.dao.PlaneDAO;
import com.petrov.airport.entity.Plane;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PlaneDAOImpl implements PlaneDAO {
    private DataBase<Plane> dataBase;

    @Override
    public DataBase<Plane> getDataBase() {
        return dataBase;
    }

    @Override
    public Optional<Plane> get(int id) {
        return dataBase.get(id, Plane.class);
    }

    @Override
    public List<Plane> getAll() {
        return dataBase.getAll(Plane.class);
    }
}
