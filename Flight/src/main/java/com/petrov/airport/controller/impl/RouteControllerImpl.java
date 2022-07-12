package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.RouteController;
import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class RouteControllerImpl implements RouteController {
    private RouteService routeService;

    @Override
    @DeleteMapping("/route/delete")
    public ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO) {
        return routeService.delete(requestEntityDTO);
    }
}
