package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseEmployeeDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDTOImpl implements ResponseEmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
}
