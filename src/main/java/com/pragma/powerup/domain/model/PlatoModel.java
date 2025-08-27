package com.pragma.powerup.domain.model;

import com.pragma.powerup.domain.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlatoModel {

    private Long id;
    private String nombreDelPlato;
    private Integer precio;
    private String descripcion;
    private String urlImagen;
    private Categoria categoria;
}
