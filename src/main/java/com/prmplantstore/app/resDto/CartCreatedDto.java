package com.prmplantstore.app.resDto;

import lombok.Data;

import java.util.List;

@Data
public class CartCreatedDto {
    private Long userId;
//    // One cart has many cart items
//    private List<Long> cartItemIds;
    private Double totalPrice;
    private Integer totalAmount;
}
