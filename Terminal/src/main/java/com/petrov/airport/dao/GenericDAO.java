package com.petrov.airport.dao;

import com.petrov.airport.configuration.database.DataBase;
import com.petrov.airport.entity.Essence;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T extends Essence> {
    DataBase<T> getDataBase();

    default T add(T object) {
        return getDataBase().add(object);
    }

    Optional<T> get(int id);

    default T update(T object) {
        return getDataBase().update(object);
    }

    default Boolean delete(T object) {
        return getDataBase().delete(object);
    }

    List<T> getAll();
}
