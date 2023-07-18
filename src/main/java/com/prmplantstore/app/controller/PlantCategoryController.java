package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.PlantCategoryMapper;
import com.prmplantstore.app.resDto.PlantCategoryCreatedDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.PlantCategory;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.PlantCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/plant-category")
@Tag(name = "Plant Category", description = "The plant category API")
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

    @GetMapping("/list")
    public ApiMessageDto<Object> list(){
        List<PlantCategory> plantCategories = (List<PlantCategory>) plantCategoryService.findAll();
        return makeResponse(true, plantCategoryMapper.toDtoList(plantCategories), "Plant categories retrieved successfully");
    }

    @PostMapping("/initialize")
    public ApiMessageDto<Object> initialize(){
        plantCategoryService.initializePlantCategories();
        return makeResponse(true, null, "Plant categories initialized successfully");
    }
}
