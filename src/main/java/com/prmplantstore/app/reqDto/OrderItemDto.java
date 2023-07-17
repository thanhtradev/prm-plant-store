package com.prmplantstore.app.reqDto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long plantId;
    private Integer quantity;
}
