package com.prmplantstore.services;

import com.prmplantstore.entities.Plant;
import com.prmplantstore.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    // Generated code: save, deleteById, getById, findAll, findAllById, count, existsById, deleteAll, delete, saveAll
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deleteById(Long id) {
        plantRepository.deleteById(id);
    }

    public Plant getById(Long id) {
        return plantRepository.findById(id).orElse(null);
    }

    public Iterable<Plant> findAll() {
        return plantRepository.findAll();
    }

    public Iterable<Plant> findAllById(Iterable<Long> ids) {
        return plantRepository.findAllById(ids);
    }

    public Long count() {
        return plantRepository.count();
    }

    public Boolean existsById(Long id) {
        return plantRepository.existsById(id);
    }

    public void deleteAll() {
        plantRepository.deleteAll();
    }

    public void delete(Plant plant) {
        plantRepository.delete(plant);
    }

}
