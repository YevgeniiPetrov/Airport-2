package com.petrov.airport.dto.impl;

import com.petrov.airport.dto.ResponseCompleted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCompletedImpl implements ResponseCompleted {
    private String message;
}
