package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseAirlineWithPlanesDTO;
import com.petrov.airport.dto.ResponsePlaneDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAirlineWithPlanesDTOImpl implements ResponseAirlineWithPlanesDTO {
    private Integer id;
    private String title;
    private Double rating;
    private List<ResponsePlaneDTO> planes;
}
