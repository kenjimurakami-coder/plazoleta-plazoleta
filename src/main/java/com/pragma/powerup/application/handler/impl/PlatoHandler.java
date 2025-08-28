package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.application.dto.response.PlatoResponseDto;
import com.pragma.powerup.application.handler.IPlatoHandler;
import com.pragma.powerup.application.mapper.IPlatoRequestMapper;
import com.pragma.powerup.application.mapper.IPlatoResponseMapper;
import com.pragma.powerup.domain.api.IPlatoServicePort;
import com.pragma.powerup.domain.model.PlatoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class PlatoHandler implements IPlatoHandler {

    private final IPlatoServicePort platoServicePort;
    private final IPlatoRequestMapper platoRequestMapper;
    private final IPlatoResponseMapper platoResponseMapper;

    @Override
    public PlatoModel savePlato(PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoRequestDto);
        PlatoModel savedPlato = platoServicePort.savePlato(platoModel);
        return savedPlato;
    }

    @Override
    public List<PlatoResponseDto> getAllPlato() {
        return platoResponseMapper.toResponseList(platoServicePort.getAllPlato());
    }

    @Override
    public Optional<PlatoResponseDto> findById(Long id) {
        return platoServicePort.findById(id)
                .map(platoResponseMapper::toResponse);
    }

    @Override
    public void updatePlato(PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoRequestDto);
        platoServicePort.updatePlato(platoModel);
    }
}
