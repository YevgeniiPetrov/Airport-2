package com.petrov.airport.repository;

import com.petrov.airport.entity.Post;

import java.util.Optional;

public interface PostRepository extends GenericRepository<Post> {
    Optional<Post> getWithEmployees(int id);
}
