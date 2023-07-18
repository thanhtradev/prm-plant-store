package com.prmplantstore.app.dto;

import com.prmplantstore.entities.Plant;
import lombok.Data;

@Data
public class CartItemDto {
    private Long id;
    private Long cartId;
    // One cart item belongs to one plant
    private PlantDto plant;
    private Integer amount;
}
