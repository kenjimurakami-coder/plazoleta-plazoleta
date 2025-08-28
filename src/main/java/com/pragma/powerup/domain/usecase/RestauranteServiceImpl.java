package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestauranteServicePort;
import com.pragma.powerup.domain.model.RestauranteModel;
import com.pragma.powerup.domain.enums.Role;
import com.pragma.powerup.domain.exception.UnauthorizedException;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;
import com.pragma.powerup.domain.spi.IUserValidationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;
    private final IUserValidationPort userValidationPort;

    @Override
    public void saveRestaurante(RestauranteModel restaurante) {
        Long userId = 1L; // Example: In a real app, you would get this from a security token.

        userValidationPort.getUserRole(userId)
                .filter(role -> role.equals(Role.OWNER))
                .orElseThrow(() -> new UnauthorizedException("Solo el propietario puede crear un restaurante."));

        restaurantePersistencePort.saveRestaurante(restaurante);
    }

    @Override
    public List<RestauranteModel> getAllRestaurantes() {
        return restaurantePersistencePort.getAllRestaurantes();
    }
}