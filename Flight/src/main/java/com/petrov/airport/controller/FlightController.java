package com.petrov.airport.controller;

import com.petrov.airport.dto.ResponseFlightDTO;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightController {
    List<ResponseFlightDTO> getFlightsBetweenDates(@RequestParam @NotNull LocalDateTime dateFrom,
                                                   @RequestParam @NotNull LocalDateTime dateTo);
}
