package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseEmployeeDTO;
import com.petrov.airport.dto.ResponsePostWithEmployeesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePostWithEmployeesDTOImpl implements ResponsePostWithEmployeesDTO {
    private Integer id;
    private String title;
    private Integer salary;
    private List<ResponseEmployeeDTO> employees;
}
