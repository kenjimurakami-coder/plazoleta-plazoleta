package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.PlatoRequestDto;
import com.pragma.powerup.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IPlatoRequestMapper {
    PlatoModel toPlato(PlatoRequestDto platoRequestDto);
}
