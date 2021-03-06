package com.petrov.airport.dto.mapper;

import com.petrov.airport.dto.RequestPostDTO;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.dto.ResponsePostWithEmployeesDTO;
import com.petrov.airport.entity.Post;

public interface PostMapper {
    ResponsePostDTO postToMap(Post post);
    ResponsePostWithEmployeesDTO postWithEmployeesToMap(Post post);
    Post mapToPost(RequestPostDTO requestPostDTO);
}
