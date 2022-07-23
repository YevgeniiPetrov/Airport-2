package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseAirlineDTO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAirlineDTOImpl implements ResponseAirlineDTO {
    private Integer id;
    private String title;
    private Double rating;
}
