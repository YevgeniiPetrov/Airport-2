package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.FlightController;
import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class FlightControllerImpl implements FlightController {
    private FlightService flightService;

    @Override
    @GetMapping("/flight/find/")
    public List<ResponseFlightDTO> getFlightsBetweenDates(
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        return flightService.getFlightsBetweenDates(dateFrom, dateTo);
    }
}
