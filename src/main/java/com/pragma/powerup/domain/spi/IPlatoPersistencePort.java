package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.PlatoModel;
import java.util.List;
import java.util.Optional;

public interface IPlatoPersistencePort {

    PlatoModel savePlato(PlatoModel plato);
    Optional<PlatoModel> findById(Long id);
    void updatePlato(PlatoModel platoModel);
    List<PlatoModel> getAllPlato();
}