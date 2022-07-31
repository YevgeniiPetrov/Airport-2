package com.petrov.airport.service.impl;

import com.petrov.airport.entity.Post;
import com.petrov.airport.repository.PostRepository;
import com.petrov.airport.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public Post get(int id) {
        return postRepository.get(id).get();
    }
}
