package com.prmplantstore.app.resDto;

import lombok.Data;

@Data
public class CartItemUpdatedDto {
    private Long id;
    private Long cartId;
    private Long plantId;
    private Integer amount;
    private Double totalPrice;
}
