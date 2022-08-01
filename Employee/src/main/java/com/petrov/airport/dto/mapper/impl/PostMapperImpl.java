package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.dto.impl.ResponsePostDTOImpl;
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

    @Override
    public ResponsePostDTO postToMap(Post post) {
        return ResponsePostDTOImpl.builder()
                .id(post.getId())
                .title(post.getTitle())
                .salary(post.getSalary())
                .build();
    }
}
