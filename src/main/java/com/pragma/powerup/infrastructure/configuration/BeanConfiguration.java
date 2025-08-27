package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IPlatoServicePort;
import com.pragma.powerup.domain.api.IRestauranteServicePort;
import com.pragma.powerup.domain.spi.IPlatoPersistencePort;
import com.pragma.powerup.domain.spi.IRestaurantePersistencePort;
import com.pragma.powerup.domain.usecase.PlatoServiceImpl;
import com.pragma.powerup.domain.usecase.RestauranteServiceImpl;
import com.pragma.powerup.infrastructure.out.jpa.adapter.PlatoJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RestauranteJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IPlatoEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IPlatoRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestauranteRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    @Bean //Restaurante
    public IRestaurantePersistencePort restaurantePersistencePort() {
        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Bean //Restaurante
    public IRestauranteServicePort restauranteServicePort() {
        return new RestauranteServiceImpl(restaurantePersistencePort());
    }

    @Bean
    public IPlatoPersistencePort platoPersistencePort() {
        return new PlatoJpaAdapter(platoRepository, platoEntityMapper);
    }

    @Bean
    public IPlatoPersistencePort platoPersistencePort(
            IPlatoRepository platoRepository,
            IPlatoEntityMapper platoEntityMapper) {

        return new PlatoJpaAdapter(platoRepository, platoEntityMapper);
    }
}