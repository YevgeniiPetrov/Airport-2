package com.petrov.airport.configuration.database;

import com.petrov.airport.entity.Essence;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public interface DataBase<T extends Essence> {
    SessionFactory getSessionFactory();
    T add(T object);
    Optional<T> get(int id, Class<T> type);
    T update(T object);
    Boolean delete(T object);
    List<T> getAll(Class<T> type);
}
