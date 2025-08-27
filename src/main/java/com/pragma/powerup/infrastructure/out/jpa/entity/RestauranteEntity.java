package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "restaurante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(unique = true, nullable = false, length = 20)
    private String nit;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 13)
    private String telefono;

    @Column(name = "url_logo", nullable = false)
    private String urlLogo;

    @Column(name = "id_propietario", nullable = false)
    private String idPropietario;
}
