package com.prmplantstore.services;

import com.prmplantstore.entities.PlantCategory;
import com.prmplantstore.repositories.PlantCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PlantCategoryService {
    @Autowired
    private PlantCategoryRepository plantCategoryRepository;

    // Generated code: save, deleteById, getById, findAll, findAllById, count, existsById, deleteAll, delete, saveAll
    public PlantCategory save(PlantCategory plantCategory) {
        return plantCategoryRepository.save(plantCategory);
    }

    public void deleteById(Long id) {
        plantCategoryRepository.deleteById(id);
    }

    public PlantCategory getById(Long id) {
        return plantCategoryRepository.findById(id).orElse(null);
    }

    public Iterable<PlantCategory> findAll() {
        return plantCategoryRepository.findAll();
    }

    public Iterable<PlantCategory> findAllById(Iterable<Long> ids) {
        return plantCategoryRepository.findAllById(ids);
    }

    public Long count() {
        return plantCategoryRepository.count();
    }

    public Boolean existsById(Long id) {
        return plantCategoryRepository.existsById(id);
    }

    public void deleteAll() {
        plantCategoryRepository.deleteAll();
    }

    public void delete(PlantCategory plantCategory) {
        plantCategoryRepository.delete(plantCategory);
    }

    public void initializePlantCategories() {
        // Create and save plant categories
        PlantCategory category1 = new PlantCategory();
        category1.setName("Indoor Plants");

        PlantCategory category2 = new PlantCategory();
        category2.setName("Outdoor Plants");

        PlantCategory category3 = new PlantCategory();
        category3.setName("Flowering Plants");

        PlantCategory category4 = new PlantCategory();
        category4.setName("Succulents");

        PlantCategory category5 = new PlantCategory();
        category5.setName("Foliage Plants");

        PlantCategory category6 = new PlantCategory();
        category6.setName("Cacti");

        PlantCategory category7 = new PlantCategory();
        category7.setName("Herbs");

        PlantCategory category8 = new PlantCategory();
        category8.setName("Vegetables");

        PlantCategory category9 = new PlantCategory();
        category9.setName("Fruit Trees");

        PlantCategory category10 = new PlantCategory();
        category10.setName("Bonsai");

        PlantCategory category11 = new PlantCategory();
        category11.setName("Air Plants");

        PlantCategory category12 = new PlantCategory();
        category12.setName("Aquatic Plants");

        PlantCategory category13 = new PlantCategory();
        category13.setName("Grasses");

        PlantCategory category14 = new PlantCategory();
        category14.setName("Climbing Plants");

        PlantCategory category15 = new PlantCategory();
        category15.setName("Shrubs");

        PlantCategory category16 = new PlantCategory();
        category16.setName("Ground Covers");

        PlantCategory category17 = new PlantCategory();
        category17.setName("Ornamental Trees");

        PlantCategory category18 = new PlantCategory();
        category18.setName("Hanging Plants");

        PlantCategory category19 = new PlantCategory();
        category19.setName("Bamboo");

        PlantCategory category20 = new PlantCategory();
        category20.setName("Moss");

        plantCategoryRepository.saveAll(Arrays.asList(
                category1, category2, category3, category4, category5,
                category6, category7, category8, category9, category10,
                category11, category12, category13, category14, category15,
                category16, category17, category18, category19, category20
        ));
    }

}
