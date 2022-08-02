package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestPostDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponsePostDTO;
import com.petrov.airport.dto.ResponsePostWithEmployeesDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface PostController {
    ResponsePostDTO get(@RequestParam int id);
    ResponseCompleted add(@RequestBody RequestPostDTO requestPostDTO);
    ResponsePostWithEmployeesDTO getWithEmployees(@RequestParam int id);
}
