package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import com.petrov.airport.dto.ResponsePlaneWithAirlineDTO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePlaneWithAirlineDTOImpl implements ResponsePlaneWithAirlineDTO {
    private Integer id;
    private String title;
    public ResponseAirlineDTO airline;
}
