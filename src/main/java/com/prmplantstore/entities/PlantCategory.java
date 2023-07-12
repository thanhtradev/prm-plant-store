package com.prmplantstore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plant_categories")
@Setter
@Getter
public class PlantCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", columnDefinition = "double default 0")
    private Double price = 0.0;

    @Column(name = "amount", columnDefinition = "int default 0")
    private Integer amount = 0;
}
