package com.prmplantstore.app.dto;

import com.prmplantstore.entities.Order;
import com.prmplantstore.entities.Plant;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;

    private Long orderId;

    private Long plantId;

    private Integer quantity;
}
