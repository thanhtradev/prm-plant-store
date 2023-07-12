package com.prmplantstore.app.resDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlantCreatedDto {
    @NotNull
    private Long plantCategoryId;
    private String name;
    private String description;
    private Double price ;
    private Integer amount;
    private String image;
}
