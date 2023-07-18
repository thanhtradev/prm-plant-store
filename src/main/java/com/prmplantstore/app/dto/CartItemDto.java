package com.prmplantstore.app.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private Long id;
    private Long cartId;
    // One cart item belongs to one plant
    private Long plantId;
    private Integer amount;
}
