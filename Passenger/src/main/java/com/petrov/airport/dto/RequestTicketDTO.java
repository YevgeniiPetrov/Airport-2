package com.petrov.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTicketDTO {
    private Integer place;
    private RequestEntityDTO passenger;
    private RequestEntityDTO flight;
}
