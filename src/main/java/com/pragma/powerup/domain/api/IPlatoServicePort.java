package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.PlatoModel;
import java.util.List;

public interface IPlatoServicePort {

    PlatoModel savePlato(PlatoModel platoModel);

    List<PlatoModel> getAllPlato();
}
