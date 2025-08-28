package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.domain.model.PlatoModel; // ¡Importa este!

import java.util.List;
import java.util.Optional;

public interface IPlatoHandler {

    PlatoModel savePlato(PlatoRequestDto platoRequestDto);

    List<PlatoResponseDto> getAllPlato();

    Optional<PlatoResponseDto> findById(Long id);

    void updatePlato( PlatoRequestDto platoRequestDto);
}