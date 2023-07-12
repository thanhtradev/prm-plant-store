package com.prmplantstore.app.dto;

import com.prmplantstore.entities.CartItem;
import com.prmplantstore.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private Long id;
    // One cart belongs to one user
    private Long userId;
    // One cart has many cart items
    private List<Long> cartItemIds;
    private Double totalPrice;
    private Integer totalAmount;
}
