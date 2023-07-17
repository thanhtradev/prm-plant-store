package com.prmplantstore.app.reqDto;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreatedDto {
    private Long userId;
    private List<OrderItemDto> orderItems;
}
