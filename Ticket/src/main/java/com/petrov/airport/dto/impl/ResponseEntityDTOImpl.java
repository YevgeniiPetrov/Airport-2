package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseEntityDTO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityDTOImpl implements ResponseEntityDTO {
    private Integer id;
}
