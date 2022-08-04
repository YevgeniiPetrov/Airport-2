package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.ResponsePlaneWithAirlineDTO;
import com.petrov.airport.dto.mapper.PlaneMapper;
import com.petrov.airport.entity.Airline;
import com.petrov.airport.entity.Plane;
import com.petrov.airport.repository.PlaneRepository;
import com.petrov.airport.service.AirlineService;
import com.petrov.airport.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaneServiceImpl implements PlaneService {
    private PlaneRepository planeRepository;
    private PlaneMapper planeMapper;
    private AirlineService airlineService;

    @Override
    public ResponsePlaneDTO get(int id) {
        return planeMapper.planeToMap(planeRepository.get(id).get());
    }

    @Override
    public ResponsePlaneWithAirlineDTO getWithAirline(int id) {
        Optional<Plane> optionalPlane = planeRepository.getWithAirline(id);
        Plane plane = optionalPlane.get();
        Airline airline = airlineService.get(plane.getAirline().getId());
        plane.setAirline(airline);
        return planeMapper.planeWithAirlineToMap(plane);
    }

    @Override
    public List<ResponsePlaneDTO> getAllByAirline(int airlineId) {
        return null;
    }
}
