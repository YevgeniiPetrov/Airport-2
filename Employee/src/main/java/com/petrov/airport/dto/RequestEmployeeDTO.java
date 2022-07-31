package com.petrov.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployeeDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private LocalDate birthdate;
}
