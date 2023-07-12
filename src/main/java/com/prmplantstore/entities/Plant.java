package com.prmplantstore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plant")
@Setter
@Getter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private PlantCategory category;

    @NotNull
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", columnDefinition = "double default 0")
    private Double price = 0.0;

    @Column(name = "amount", columnDefinition = "int default 0")
    private Integer amount = 0;

    @Column(name = "image", length = 255)
    private String image;
}
