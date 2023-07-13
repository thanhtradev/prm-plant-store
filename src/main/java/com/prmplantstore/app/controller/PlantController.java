package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.PlantMapper;
import com.prmplantstore.app.resDto.PlantCreatedDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.Plant;
import com.prmplantstore.entities.PlantCategory;
import com.prmplantstore.exception.BadRequestException;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.PlantCategoryService;
import com.prmplantstore.services.PlantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/plant")
@Tag(name = "Plant", description = "Plant API")
public class PlantController extends BaseController {
    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantCategoryService plantCategoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlantMapper plantMapper;

    @PostMapping()
    public ApiMessageDto<Object> create(@Valid @RequestBody PlantCreatedDto plantCreatedDto){
        PlantCategory plantCategory = plantCategoryService.getById(plantCreatedDto.getPlantCategoryId());
        if(plantCategory == null){
            throw new BadRequestException("Plant category not found");
        }
        Plant  plant = modelMapper.map(plantCreatedDto, Plant.class);
        plant.setCategory(plantCategory);
        Plant savedPlant = plantService.save(plant);
        return makeResponse(true, plantMapper.toDto(savedPlant), "Plant created successfully");
    }

    @GetMapping("/{id}")
    public ApiMessageDto<Object> getPlantById(@PathVariable Long id){
        Plant plant = plantService.getById(id);
        if(plant == null){
            throw new BadRequestException("Plant not found");
        }
        return makeResponse(true, plantMapper.toDto(plant), "Plant retrieved successfully");
    }

    @GetMapping("/list")
    public ApiMessageDto<Object> getAllPlants(){
        List<Plant> plants = (List<Plant>) plantService.findAll();
        return makeResponse(true, plantMapper.toDtoList(plants), "Plants retrieved successfully");
    }

    // Get plants by category id
    @GetMapping("/category/{id}")
    public ApiMessageDto<Object> getPlantsByCategoryId(@PathVariable Long id){
        List<Plant> plants = (List<Plant>) plantService.findAllByCategoryId(id);
        return makeResponse(true, plantMapper.toDtoList(plants), "Plants retrieved successfully");
    }
}
