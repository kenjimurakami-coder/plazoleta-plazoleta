// src/main/java/com/pragma/powerup/infrastructure/out/jpa/adapter/PlatoJpaAdapter.java

package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.PlatoModel;
import com.pragma.powerup.domain.model.RestauranteModel;
import com.pragma.powerup.domain.spi.IPlatoPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.PlatoEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestauranteEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IPlatoEntityMapper; // Asumimos que tienes un mapper
import com.pragma.powerup.infrastructure.out.jpa.repository.IPlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper; // Inyecta el mapper

    @Override
    public PlatoModel savePlato(PlatoModel plato) {
        PlatoEntity platoEntity = platoEntityMapper.toEntity(plato);
        PlatoEntity savedEntity = platoRepository.save(platoEntity);
        return platoEntityMapper.toPlatoModel(savedEntity);
    }

    @Override
    public List<PlatoModel> getAllPlato() {
        List<PlatoEntity> entityList = platoRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return platoEntityMapper.toPlatoModelList(entityList);
    }
}