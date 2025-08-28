package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IPlatoServicePort;
import com.pragma.powerup.domain.model.PlatoModel;
import com.pragma.powerup.domain.spi.IPlatoPersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;
import com.pragma.powerup.domain.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;
    private final IRestaurantePersistencePort restaurantePersistencePort;

    @Override
    public PlatoModel savePlato(PlatoModel plato) {
        restaurantePersistencePort.findById(plato.getIdRestaurante())
                .orElseThrow(() -> new UnauthorizedException("Restaurante no encontrado"));
        return platoPersistencePort.savePlato(plato);
    }

    @Override
    public List<PlatoModel> getAllPlato() {
        return platoPersistencePort.getAllPlato();
    }

    @Override
    public Optional<PlatoModel> findById(Long id) {
        return platoPersistencePort.findById(id);
    }

    @Override
    public void updatePlato(PlatoModel platoModel) {
        Optional<PlatoModel> optionalPlato = platoPersistencePort.findById(platoModel.getId());
        PlatoModel existingPlato = optionalPlato
                .orElseThrow(() -> new UnauthorizedException("Plato no encontrado"));

        existingPlato.setPrecio(platoModel.getPrecio());
        existingPlato.setDescripcion(platoModel.getDescripcion());

        platoPersistencePort.savePlato(existingPlato);
    }

}