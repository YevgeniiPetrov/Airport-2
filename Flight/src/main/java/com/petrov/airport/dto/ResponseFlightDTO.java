package com.petrov.airport.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface ResponseFlightDTO {
    void setId(Integer id);
    void setDeparture(LocalDateTime departure);
    void setDuration(LocalTime duration);
    void setRoute(ResponseRouteDTO route);
    void setState(ResponseStateDTO state);
}
