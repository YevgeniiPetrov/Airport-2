package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponsePassengerDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePassengerDTOImpl implements ResponsePassengerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
