package com.petrov.airport.repository;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.entity.Essence;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends Essence> {
    GenericDAO<T> getGenericDAO();

    default T add(T object) {
        return getGenericDAO().add(object);
    }

    default Optional<T> get(int id) {
        return getGenericDAO().get(id);
    }

    default T update(T object) {
        return getGenericDAO().update(object);
    }

    default Boolean delete(T object) {
        return getGenericDAO().delete(object);
    }

    default List<T> getAll() {
        return getGenericDAO().getAll();
    }
}