package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseStateDTO;
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
public class ResponseStateDTOImpl implements ResponseStateDTO {
    private Integer id;
    private String title;
}
