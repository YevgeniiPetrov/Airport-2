package com.petrov.airport.dto.mapper.impl;

import com.petrov.airport.dto.RequestPostDTO;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.dto.ResponsePostWithEmployeesDTO;
import com.petrov.airport.dto.impl.ResponsePostDTOImpl;
import com.petrov.airport.dto.impl.ResponsePostWithEmployeesDTOImpl;
import com.petrov.airport.dto.mapper.EmployeeMapper;
import com.petrov.airport.dto.mapper.PostMapper;
import com.petrov.airport.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostMapperImpl implements PostMapper {
    private EmployeeMapper employeeMapper;

    @Override
    public ResponsePostDTO postToMap(Post post) {
        return ResponsePostDTOImpl.builder()
                .id(post.getId())
                .title(post.getTitle())
                .salary(post.getSalary())
                .build();
    }

    @Override
    public ResponsePostWithEmployeesDTO postWithEmployeesToMap(Post post) {
        return ResponsePostWithEmployeesDTOImpl.builder()
                .id(post.getId())
                .title(post.getTitle())
                .salary(post.getSalary())
                .employees(post.getEmployees().stream()
                        .map(employeeMapper::employeeToMap)
                        .collect(Collectors.toList()))
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
