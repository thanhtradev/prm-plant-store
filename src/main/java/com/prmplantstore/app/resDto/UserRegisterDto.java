package com.prmplantstore.app.resDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterDto {
    @NotBlank
    private String username;
    private String phone;
    private String email;
    private String address;
    @NotBlank
    private String password;
    private String role;

}
