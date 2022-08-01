package com.petrov.airport.service;

import com.petrov.airport.dto.RequestPostDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePostDTO;

public interface PostService {
    ResponsePostDTO get(int id);
    ResponseCompleted add(RequestPostDTO requestPostDTO);
}
