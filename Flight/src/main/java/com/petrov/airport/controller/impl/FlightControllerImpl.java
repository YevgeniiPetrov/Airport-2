package com.petrov.airport.controller.impl;

import com.petrov.airport.controller.FlightController;
import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestFlightChangeDeparture;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class FlightControllerImpl implements FlightController {
    private FlightService flightService;

    @Override
    @GetMapping("/flight/get/")
    public ResponseFlightDTO get(@RequestParam int id) {
        return flightService.get(id);
    }

    @Override
    @GetMapping("/flight/find/")
    public List<ResponseFlightDTO> getFlightsBetweenDates(
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        return flightService.getFlightsBetweenDates(dateFrom, dateTo);
    }

    @Override
    @DeleteMapping("/flight/delete")
    public ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO) {
        return flightService.delete(requestEntityDTO);
    }

    @Override
    @PostMapping("/flight/update")
    public ResponseCompleted update(@RequestBody @Valid RequestFlightChangeDeparture requestFlightChangeDeparture) {
        return flightService.update(requestFlightChangeDeparture);
    }

    @Override
    @GetMapping("/flight/get/terminal")
    public List<ResponseFlightDTO> getAllByTerminal(@RequestParam int id) {
        return flightService.getAllByTerminal(id);
    }
}
