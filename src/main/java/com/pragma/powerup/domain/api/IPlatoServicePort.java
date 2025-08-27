package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.PlatoModel;

import java.util.List;

public interface IPlatoServicePort {

    void savePlato(PlatoModel platoModel);

    List<PlatoModel> getAllPlato();
}
