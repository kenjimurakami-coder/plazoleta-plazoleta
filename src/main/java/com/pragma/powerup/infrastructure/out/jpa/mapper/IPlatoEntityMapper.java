package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.PlatoModel;
import com.pragma.powerup.domain.model.RestauranteModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.PlatoEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)

public interface IPlatoEntityMapper {
    PlatoEntity toEntity(PlatoModel plato);
    PlatoModel toPlatoModel(PlatoEntity platoEntity);
    List<PlatoModel> toPlatoModelList(List<PlatoEntity> platoEntityList);
}