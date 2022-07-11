package com.petrov.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPassengerTicketsDTO {
    @NotNull
    @Valid
    private RequestEntityDTO passenger;
    @NotNull
    @Valid
    private List<RequestPassengerTicketDTO> tickets;
}
