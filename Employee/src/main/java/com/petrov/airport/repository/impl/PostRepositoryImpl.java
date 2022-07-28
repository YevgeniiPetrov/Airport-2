package com.petrov.airport.repository.impl;

import com.petrov.airport.dao.GenericDAO;
import com.petrov.airport.dao.PostDAO;
import com.petrov.airport.entity.Post;
import com.petrov.airport.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private PostDAO postDAO;

    @Override
    public GenericDAO<Post> getGenericDAO() {
        return postDAO;
    }
}
