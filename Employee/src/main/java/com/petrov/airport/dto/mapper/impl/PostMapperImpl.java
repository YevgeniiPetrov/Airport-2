package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.mapper.PostMapper;
import com.petrov.airport.entity.Post;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PostMapperImpl implements PostMapper {
    @Override
    public Post mapToPost(RequestEntityDTO requestEntityDTO) {
        return Post.builder()
                .id(requestEntityDTO.getId())
                .build();
    }
}
