package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.PlantCategoryMapper;
import com.prmplantstore.app.resDto.PlantCategoryCreatedDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.PlantCategory;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.PlantCategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("app/plant-category")
public class PlantCategoryController extends BaseController {
    @Autowired
    private PlantCategoryService plantCategoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlantCategoryMapper plantCategoryMapper;

    @PostMapping()
    public ApiMessageDto<Object> create(@Valid @RequestBody PlantCategoryCreatedDto plantCategoryCreatedDto){
        PlantCategory plantCategory = modelMapper.map(plantCategoryCreatedDto, PlantCategory.class);
        PlantCategory savedPlantCategory = plantCategoryService.save(plantCategory);

        return makeResponse(true, plantCategoryMapper.toDto(savedPlantCategory), "Plant category created successfully");
    }
}
