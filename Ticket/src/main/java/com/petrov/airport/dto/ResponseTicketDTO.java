package com.petrov.airport.dto;

import java.time.LocalDateTime;

public interface ResponseTicketDTO {
    void setId(Integer id);
    void setCreationDate(LocalDateTime creationDate);
    void setPlace(Integer place);
    void setPassenger(ResponseEntityDTO passenger);
    void setFlight(ResponseEntityDTO flight);
}
