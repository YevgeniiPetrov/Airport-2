package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.entity.Post;

public interface PostMapper {
    Post mapToPost(RequestEntityDTO requestEntityDTO);
}