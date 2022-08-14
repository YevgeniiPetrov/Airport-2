package com.petrov.airport.dao;

import com.petrov.airport.entity.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {
    Optional<User> get(String email);
}
