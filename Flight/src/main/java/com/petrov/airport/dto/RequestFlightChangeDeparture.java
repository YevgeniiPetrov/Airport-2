package com.petrov.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestFlightChangeDeparture {
    @NotNull
    private Integer id;
    @NotNull
    private LocalDateTime departure;
}
