package com.prmplantstore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String phone;

    private String email;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private EUserRole role;
}
