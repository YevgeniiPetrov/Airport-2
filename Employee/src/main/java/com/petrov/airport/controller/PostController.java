package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponsePostDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface PostController {
    ResponsePostDTO get(@RequestParam int id);
}
