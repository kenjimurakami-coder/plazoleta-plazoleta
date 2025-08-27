package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.RestauranteRequestDto;
import com.pragma.powerup.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IRestauranteRequestMapper {
    RestauranteModel toRestaurante(RestauranteRequestDto restauranteRequestDto);
}
