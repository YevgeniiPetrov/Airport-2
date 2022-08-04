package com.petrov.airport.dto;

import java.util.List;

public interface ResponseAirlineWithPlanesDTO {
    void setPlanes(List<ResponsePlaneDTO> planes);
}
