package com.prmplantstore.repositories;

import com.prmplantstore.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository  extends JpaRepository<Plant,Long>, JpaSpecificationExecutor<Plant> {
    Iterable<Plant> findAllByCategoryId(Long categoryId);
}
