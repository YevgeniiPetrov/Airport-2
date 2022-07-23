package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponsePlaneDTO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePlaneDTOImpl implements ResponsePlaneDTO {
    private Integer id;
    private String title;
}
