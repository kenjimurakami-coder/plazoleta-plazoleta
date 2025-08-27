package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.PlatoModel;
import java.util.List;

public interface IPlatoPersistencePort {

    PlatoModel savePlato(PlatoModel plato);

    List<PlatoModel> getAllPlato();
}