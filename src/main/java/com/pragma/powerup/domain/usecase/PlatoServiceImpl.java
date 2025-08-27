package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IPlatoServicePort;
import com.pragma.powerup.domain.model.PlatoModel;
import com.pragma.powerup.domain.spi.IPlatoPersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;
import com.pragma.powerup.domain.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;
    private final IRestaurantePersistencePort restaurantePersistencePort;

    @Override
    public PlatoModel savePlato(PlatoModel plato) {
        restaurantePersistencePort.findById(plato.getIdRestaurante())
                .orElseThrow(() -> new DomainException("El restaurante con el ID proporcionado no existe."));
        return platoPersistencePort.savePlato(plato);
    }

    @Override
    public List<PlatoModel> getAllPlato() {
        return platoPersistencePort.getAllPlato();
    }
}
