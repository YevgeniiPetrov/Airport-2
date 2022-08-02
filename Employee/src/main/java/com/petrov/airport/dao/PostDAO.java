package com.petrov.airport.dao;

import com.petrov.airport.entity.Post;

import java.util.Optional;

public interface PostDAO extends GenericDAO<Post> {
    Optional<Post> getWithEmployees(int id);
}
