package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseStateDTO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStateDTOImpl implements ResponseStateDTO {
    private Integer id;
    private String title;
}
