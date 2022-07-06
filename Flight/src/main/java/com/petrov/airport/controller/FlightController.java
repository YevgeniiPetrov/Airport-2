package com.petrov.airport.controller;

import com.petrov.airport.dto.RequestEntityDTO;
import com.petrov.airport.dto.RequestFlightChangeDeparture;
import com.petrov.airport.dto.ResponseCompleted;
import com.petrov.airport.dto.ResponseFlightDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightController {
    ResponseFlightDTO get(@RequestParam int id);
    List<ResponseFlightDTO> getFlightsBetweenDates(@RequestParam @NotNull LocalDateTime dateFrom,
                                                   @RequestParam @NotNull LocalDateTime dateTo);
    ResponseCompleted delete(@RequestBody @Valid RequestEntityDTO requestEntityDTO);
    ResponseCompleted update(@RequestBody @Valid RequestFlightChangeDeparture requestFlightChangeDeparture);
}
