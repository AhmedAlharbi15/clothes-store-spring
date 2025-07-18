package com.isb.clothes.store.modules.clothes.mapper;

import com.isb.clothes.store.modules.clothes.dto.ClothesDto;
import com.isb.clothes.store.modules.clothes.entity.ClothesEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClothesMapper {

    @Mapping(target = "rating.rate", source = "rate")
    @Mapping(target = "rating.count", source = "count")
    ClothesDto toDto(ClothesEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "rate", source = "rating.rate")
    @Mapping(target = "count", source = "rating.count")
    ClothesEntity toEntity(ClothesDto dto);

    List<ClothesDto> toDtoList(List<ClothesEntity> entities);
    List<ClothesEntity> toEntityList(List<ClothesDto> dtos);
}