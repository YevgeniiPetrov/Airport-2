package com.petrov.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestTerminalDTO {
    @NotNull
    private String title;
}
