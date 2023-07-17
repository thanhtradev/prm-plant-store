package com.prmplantstore.app.dto;

import com.prmplantstore.entities.OrderItem;
import com.prmplantstore.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private Date date;
    private Double total;
    private Long userId;
    private String status;
    private List<Long> orderItemIds;
}
