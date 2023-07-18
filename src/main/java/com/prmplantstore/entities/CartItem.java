package com.prmplantstore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Setter
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One cart item belongs to one cart
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    // One cart item belongs to one plant
    @ManyToOne
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;

    @Column(name = "amount", columnDefinition = "int default 0")
    private Integer amount = 0;
}
