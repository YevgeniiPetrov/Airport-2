package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.ResponseFlightWithAirlinesDTO;
import com.petrov.airport.dto.ResponseRouteDTO;
import com.petrov.airport.dto.ResponseStateDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFlightWithAirlinesDTOIml implements ResponseFlightWithAirlinesDTO {
    private Integer id;
    private LocalDateTime departure;
    private LocalTime duration;
    private ResponseRouteDTO route;
    private ResponseStateDTO state;
    private List<ResponseAirlineDTO> airlines;
}
