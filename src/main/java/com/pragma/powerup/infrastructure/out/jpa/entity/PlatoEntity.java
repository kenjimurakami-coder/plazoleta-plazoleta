package com.pragma.powerup.infrastructure.out.jpa.entity;

import com.pragma.powerup.domain.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "plato")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PlatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombreDelPlato;

    private Integer precio;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(name = "url_imagen", nullable = false)
    private String urlImagen;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Long idRestaurante;

}
