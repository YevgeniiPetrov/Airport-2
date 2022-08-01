package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.PostController;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PostControllerImpl implements PostController {
    private PostService postService;

    @Override
    @GetMapping("/post/get")
    public ResponsePostDTO get(int id) {
        return postService.get(id);
    }
}
