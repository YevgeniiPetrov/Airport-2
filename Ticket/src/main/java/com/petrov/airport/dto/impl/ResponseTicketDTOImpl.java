package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseFlightDTO;
import com.petrov.airport.dto.ResponseTicketDTO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTicketDTOImpl implements ResponseTicketDTO {
    private Integer id;
    private LocalDateTime creationDate;
    private Integer place;
    private Integer passenger;
    private ResponseFlightDTO flight;
}
