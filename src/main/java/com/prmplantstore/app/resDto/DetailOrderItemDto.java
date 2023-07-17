package com.prmplantstore.app.resDto;

import com.prmplantstore.app.dto.PlantDto;
import lombok.Data;

@Data
public class DetailOrderItemDto {
    private Long id;
    private PlantDto plant;
    private Integer quantity;
}
