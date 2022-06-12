package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseRouteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRouteDTOImpl implements ResponseRouteDTO {
    private Integer id;
    private String from;
    private String to;
}
