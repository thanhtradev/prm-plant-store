package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.PlantCategoryDto;
import com.prmplantstore.entities.PlantCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantCategoryMapper extends EntityDtoMapper<PlantCategoryDto, PlantCategory>{
}
