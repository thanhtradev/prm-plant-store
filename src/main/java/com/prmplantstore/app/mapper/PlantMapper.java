package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.PlantDto;
import com.prmplantstore.entities.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantMapper extends EntityDtoMapper<PlantDto, Plant>{
    @Mapping(source = "category.id", target = "plantCategoryId")
    PlantDto toDto(Plant plant);
}
