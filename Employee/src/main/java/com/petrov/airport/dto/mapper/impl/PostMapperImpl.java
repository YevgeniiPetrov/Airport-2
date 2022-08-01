package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestPostDTO;
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
    public ResponsePostDTO postToMap(Post post) {
        return ResponsePostDTOImpl.builder()
                .id(post.getId())
                .title(post.getTitle())
                .salary(post.getSalary())
                .build();
    }

    @Override
    public Post mapToPost(RequestPostDTO requestPostDTO) {
        return Post.builder()
                .title(requestPostDTO.getTitle())
                .salary(requestPostDTO.getSalary())
                .build();
    }
}
