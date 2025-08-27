package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.application.dto.response.RestauranteResponseDto;
import com.pragma.powerup.domain.model.RestauranteModel;

import java.util.List;

public interface IRestauranteHandler {

    void saveRestaurante(RestauranteRequestDto restauranteRequestDto);

    List<RestauranteResponseDto> getAllRestaurantes();
}
