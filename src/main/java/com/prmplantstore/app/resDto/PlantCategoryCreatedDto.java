package com.prmplantstore.app.resDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlantCategoryCreatedDto {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
}
