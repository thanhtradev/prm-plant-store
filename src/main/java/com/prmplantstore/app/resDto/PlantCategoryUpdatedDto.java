package com.prmplantstore.app.resDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlantCategoryUpdatedDto {
    @NotNull
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
}
