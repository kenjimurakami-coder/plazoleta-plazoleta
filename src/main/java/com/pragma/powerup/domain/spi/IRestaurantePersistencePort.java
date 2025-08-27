package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.RestauranteModel;

import java.util.List;
import java.util.Optional;

public interface IRestaurantePersistencePort {

    RestauranteModel saveRestaurante(RestauranteModel restaurante);

    List<RestauranteModel> getAllRestaurantes();

    Optional<RestauranteModel> findById(Long id);
}
