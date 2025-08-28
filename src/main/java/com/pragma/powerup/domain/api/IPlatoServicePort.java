package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.PlatoModel;
import java.util.List;
import java.util.Optional;

public interface IPlatoServicePort {

    PlatoModel savePlato(PlatoModel platoModel);

    List<PlatoModel> getAllPlato();

    Optional<PlatoModel> findById(Long id);

    void updatePlato(PlatoModel platoModel);
}
