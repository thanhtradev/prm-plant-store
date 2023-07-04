package com.prmplantstore.app.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String phone;
    private String email;
    private String address;
    private String role;
}
