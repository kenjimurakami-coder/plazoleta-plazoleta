package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.PlatoModel;
import com.pragma.powerup.domain.spi.IPlatoPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.PlatoEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IPlatoEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IPlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatoJpaAdapter implements IPlatoPersistencePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    @Override
    public PlatoModel savePlato(PlatoModel platoModel) {
        PlatoEntity platoEntity = platoEntityMapper.toEntity(platoModel);
        PlatoEntity savedEntity = platoRepository.save(platoEntity);
        return platoEntityMapper.toPlatoModel(savedEntity);
    }

    @Override
    public Optional<PlatoModel> findById(Long id) {
        return platoRepository.findById(id)
                .map(platoEntityMapper::toPlatoModel);
    }

    @Override
    public void updatePlato(PlatoModel platoModel) {
        PlatoEntity platoEntity = platoEntityMapper.toEntity(platoModel);
        platoRepository.save(platoEntity);
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