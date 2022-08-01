package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponsePostDTO;
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
public class ResponsePostDTOImpl implements ResponsePostDTO {
    private Integer id;
    private String title;
    private Integer salary;
}
