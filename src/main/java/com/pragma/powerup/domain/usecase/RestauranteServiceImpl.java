package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestauranteServicePort;
import com.pragma.powerup.domain.model.RestauranteModel;
import com.pragma.powerup.domain.enums.Role;
import com.pragma.powerup.domain.exception.UnauthorizedException;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;
import com.pragma.powerup.infrastructure.out.feign.client.UserValidationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements IRestauranteServicePort {

    private final IRestaurantePersistencePort restaurantePersistencePort;
    private final UserValidationClient userValidationClient;;

    @Override
    public void saveRestaurante(RestauranteModel restaurante) {
       /* String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Long userId = userValidationClient.getUserIdByCorreo(userEmail);

        userValidationClient.getUserRole(userId)
                .filter(role -> role.equals(Role.OWNER))
                .orElseThrow(() -> new UnauthorizedException("Solo el propietario puede crear un restaurante."));

        if (!restaurante.getIdPropietario().equals(userId)) {
            throw new UnauthorizedException("El id del propietario no coincide con el usuario autenticado.");
        }*/

        restaurantePersistencePort.saveRestaurante(restaurante);
    }

    @Override
    public List<RestauranteModel> getAllRestaurantes() {
        return restaurantePersistencePort.getAllRestaurantes();
    }
}