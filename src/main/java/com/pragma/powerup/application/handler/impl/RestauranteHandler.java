package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.application.handler.IRestauranteHandler;
import com.pragma.powerup.application.mapper.IRestauranteRequestMapper;
import com.pragma.powerup.application.mapper.IRestauranteResponseMapper;
import com.pragma.powerup.domain.api.IRestauranteServicePort;
import com.pragma.powerup.domain.model.RestauranteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class RestauranteHandler implements IRestauranteHandler {

    private final IRestauranteServicePort restauranteServicePort;
    private final IRestauranteRequestMapper restauranteRequestMapper;
    private final IRestauranteResponseMapper restauranteResponseMapper;

    public void saveRestaurante(RestauranteRequestDto restauranteRequestDto) {
        RestauranteModel restauranteModel = restauranteRequestMapper.toRestaurante(restauranteRequestDto);
        restauranteServicePort.saveRestaurante(restauranteModel);
    }

    @Override
    public List<RestauranteResponseDto> getAllRestaurantes() {
        return restauranteResponseMapper.toResponseList(restauranteServicePort.getAllRestaurantes());
    }

}
