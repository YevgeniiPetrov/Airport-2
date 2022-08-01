package com.petrov.airport.service.impl;

import com.petrov.airport.dto.RequestPostDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.dto.mapper.PostMapper;
import com.petrov.airport.repository.PostRepository;
import com.petrov.airport.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private PostMapper postMapper;
    private ResponseCompleted responseCompleted;

    @Override
    public ResponsePostDTO get(int id) {
        return postMapper.postToMap(postRepository.get(id).get());
    }

    @Override
    public ResponseCompleted add(RequestPostDTO requestPostDTO) {
        postRepository.add(postMapper.mapToPost(requestPostDTO));
        return responseCompleted;
    }
}
