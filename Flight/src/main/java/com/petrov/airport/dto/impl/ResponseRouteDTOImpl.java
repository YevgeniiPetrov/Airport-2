package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseRouteDTO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRouteDTOImpl implements ResponseRouteDTO {
    private Integer id;
    private String from;
    private String to;
}
