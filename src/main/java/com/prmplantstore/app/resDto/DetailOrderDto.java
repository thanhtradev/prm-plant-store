package com.prmplantstore.app.resDto;

import com.prmplantstore.app.dto.PlantDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DetailOrderDto {
    private Long id;
    private Date date;
    private Double total;
    private String status;
    private List<DetailOrderItemDto> orderItems;
}
