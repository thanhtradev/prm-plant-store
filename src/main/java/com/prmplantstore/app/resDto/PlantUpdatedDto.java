package com.prmplantstore.app.resDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlantUpdatedDto {
    @NotNull
    private Long id;
    private Long plantCategoryId;
    private String name;
    private String description;
    private Double price ;
    private Integer amount;
    private String image;
}
