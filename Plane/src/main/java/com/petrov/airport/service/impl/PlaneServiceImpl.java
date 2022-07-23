package com.petrov.airport.service.impl;

import com.petrov.airport.dto.ResponsePlaneDTO;
import com.petrov.airport.dto.mapper.PlaneMapper;
import com.petrov.airport.repository.PlaneRepository;
import com.petrov.airport.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaneServiceImpl implements PlaneService {
    private PlaneRepository planeRepository;
    private PlaneMapper planeMapper;

    @Override
    public ResponsePlaneDTO get(int id) {
        return planeMapper.planeToMap(planeRepository.get(id).get());
    }
}
