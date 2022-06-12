package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.dto.ResponseRouteDTO;
import com.petrov.airport.dto.ResponseStateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFlightDTOImpl implements ResponseFlightDTO {
    private Integer id;
    private LocalDateTime departure;
    private LocalTime duration;
    private ResponseRouteDTO route;
    private ResponseStateDTO state;
}
