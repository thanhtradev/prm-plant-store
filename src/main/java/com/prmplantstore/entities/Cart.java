package com.prmplantstore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "carts")
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One cart belongs to one user
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // One cart has many cart items
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    @Column(name = "total_price", columnDefinition = "double default 0")
    private Double totalPrice = 0.0;

    @Column(name = "total_amount", columnDefinition = "int default 0")
    private Integer totalAmount = 0;

}
