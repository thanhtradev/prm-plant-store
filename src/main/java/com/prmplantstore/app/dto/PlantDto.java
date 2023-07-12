package com.prmplantstore.app.dto;

import lombok.Data;

@Data
public class PlantDto {
    private Long id;
    private Long plantCategoryId;
    private String name;
    private String description;
    private Double price ;
    private Integer amount;
    private String image;

}
