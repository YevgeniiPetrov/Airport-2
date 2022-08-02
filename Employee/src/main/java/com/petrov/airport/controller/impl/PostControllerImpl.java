package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.PostController;
import com.petrov.airport.dto.RequestPostDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.dto.ResponsePostWithEmployeesDTO;
import com.petrov.airport.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostControllerImpl implements PostController {
    private PostService postService;

    @Override
    @GetMapping("/post/get")
    public ResponsePostDTO get(int id) {
        return postService.get(id);
    }

    @Override
    @PostMapping("/post/add")
    public ResponseCompleted add(RequestPostDTO requestPostDTO) {
        return postService.add(requestPostDTO);
    }

    @Override
    @GetMapping("/post/getWithEmployees")
    public ResponsePostWithEmployeesDTO getWithEmployees(int id) {
        return postService.getWithEmployees(id);
    }
}
