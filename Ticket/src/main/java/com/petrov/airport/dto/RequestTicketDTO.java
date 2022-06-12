package com.petrov.airport.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestTicketDTO {
    @Setter
    private LocalDateTime creationDate;
    @NotNull
    private Integer place;
    @NotNull
    @Valid
    private RequestEntityDTO passenger;
    @NotNull
    @Valid
    private RequestEntityDTO flight;
}
