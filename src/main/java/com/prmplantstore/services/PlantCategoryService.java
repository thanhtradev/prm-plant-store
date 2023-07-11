package com.prmplantstore.services;

import com.prmplantstore.entities.PlantCategory;
import com.prmplantstore.repositories.PlantCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
