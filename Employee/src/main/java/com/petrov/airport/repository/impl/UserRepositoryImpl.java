package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.UserDAO;
import com.petrov.airport.entity.User;
import com.petrov.airport.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private UserDAO userDAO;

    @Override
    public GenericDAO<User> getGenericDAO() {
        return userDAO;
    }

    @Override
    public Optional<User> get(String email) {
        return userDAO.get(email);
    }
}
