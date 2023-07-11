package com.prmplantstore.repositories;

import com.prmplantstore.entities.PlantCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantCategoryRepository extends JpaRepository<PlantCategory,Long>, JpaSpecificationExecutor<PlantCategory> {
}
