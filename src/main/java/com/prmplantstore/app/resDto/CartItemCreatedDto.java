package com.prmplantstore.app.resDto;

import lombok.Data;

@Data
public class CartItemCreatedDto {
    private Long cartId;
    // One cart item belongs to one plant
    private Long plantId;
    private Integer amount;
    private Double totalPrice;
}
