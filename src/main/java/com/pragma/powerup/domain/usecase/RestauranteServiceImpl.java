package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestauranteServicePort;
import com.pragma.powerup.domain.model.RestauranteModel;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;

import java.util.List;

public class RestauranteServiceImpl implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;

    public RestauranteServiceImpl(IRestaurantePersistencePort restaurantePersistencePort) {
        this.restaurantePersistencePort = restaurantePersistencePort;
    }

    @Override
    public void saveRestaurante(RestauranteModel restaurante) { restaurantePersistencePort.saveRestaurante(restaurante); }

    @Override
    public List<RestauranteModel> getAllRestaurantes() {return restaurantePersistencePort.getAllRestaurantes();}

}
