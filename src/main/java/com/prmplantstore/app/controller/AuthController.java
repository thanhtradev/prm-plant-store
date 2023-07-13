package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.UserMapper;
import com.prmplantstore.app.resDto.UserLoginDto;
import com.prmplantstore.app.resDto.UserRegisterDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.Cart;
import com.prmplantstore.entities.EUserRole;
import com.prmplantstore.entities.User;
import com.prmplantstore.exception.BadRequestException;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.CartService;
import com.prmplantstore.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/auth")
@Tag(name = "Auth", description = "The auth API")
public class AuthController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ApiMessageDto<Object> signup(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        // Check if the username is already taken
        // Check if the email is already taken
        // Check if the phone is already taken
        // Create a new user
        // Save the user to the database
        if (userRegisterDto.getUsername() != null && userService.existsByUsername(userRegisterDto.getUsername()))
            throw new BadRequestException("Username is already taken");
        if (userRegisterDto.getEmail() != null && userService.existsByEmail(userRegisterDto.getEmail()))
            throw new BadRequestException("Email is already taken");
        if (userRegisterDto.getPhone() != null && userService.existsByPhone(userRegisterDto.getPhone()))
            throw new BadRequestException("Phone is already taken");
        // Regex to validate phone number
        if (userRegisterDto.getPhone() != null && !userRegisterDto.getPhone().matches("^\\+?[0-9]{10,13}$")) {
            throw new BadRequestException("Phone number is invalid");
        }
        User user = modelMapper.map(userRegisterDto, User.class);
        user.setRole(EUserRole.USER);
        User savedUser = userService.save(user);
        // Create new cart for the user
         Cart cart = new Cart();
         cart.setUser(savedUser);
         cartService.save(cart);

        return makeResponse(true, userMapper.toDto(savedUser), "User created successfully");
    }

    @PostMapping("/login")
    public ApiMessageDto<Object> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        // Check if the username exists
        // Check if the password is correct
        // Return the user
        User user = userService.getByUsername(userLoginDto.getUsername());
        if (user == null) {
            throw new BadRequestException("Username or password is incorrect");
        }
        if (!user.getPassword().equals(userLoginDto.getPassword())) {
            throw new BadRequestException("Username or password is incorrect");
        }

        return makeResponse(true, userMapper.toDto(user), "User signed in successfully");
    }
}
