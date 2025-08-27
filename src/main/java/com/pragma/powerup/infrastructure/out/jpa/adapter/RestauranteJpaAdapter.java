package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.RestauranteModel;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestauranteEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

public class RestauranteJpaAdapter implements IRestaurantePersistencePort{

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    @Override
    public RestauranteModel saveRestaurante(RestauranteModel restauranteModel) {
        RestauranteEntity restauranteEntity = restauranteRepository.save(restauranteEntityMapper.toEntity(restauranteModel));
        return restauranteEntityMapper.toRestauranteModel(restauranteEntity);
    }

    @Override
    public List<RestauranteModel> getAllRestaurantes() {
        List<RestauranteEntity> entityList = restauranteRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restauranteEntityMapper.toRestauranteModelList(entityList);
    }

    @Override
    public Optional<RestauranteModel> findById(Long id) {
        return restauranteRepository.findById(id)
                .map(restauranteEntityMapper::toRestauranteModel);
    }
}
