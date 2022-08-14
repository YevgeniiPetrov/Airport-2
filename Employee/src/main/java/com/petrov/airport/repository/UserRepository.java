package com.petrov.airport.repository;

import com.petrov.airport.entity.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {
    Optional<User> get(String email);
}
