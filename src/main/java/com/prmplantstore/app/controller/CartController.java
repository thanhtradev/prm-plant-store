package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.CartMapper;
import com.prmplantstore.app.resDto.CartCreatedDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.Cart;
import com.prmplantstore.entities.User;
import com.prmplantstore.exception.BadRequestException;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.CartItemService;
import com.prmplantstore.services.CartService;
import com.prmplantstore.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Cart", description = "The cart API")
public class CartController extends BaseController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartMapper cartMapper;

    @PostMapping()
    public ApiMessageDto<Object> create(@Valid @RequestBody CartCreatedDto cartCreatedDto) {
        User user = userService.getById(cartCreatedDto.getUserId());
        if (user == null) {
            throw new BadRequestException("User not found");
        }
        Cart cart = modelMapper.map(cartCreatedDto, Cart.class);
        cart.setUser(user);
        Cart savedCart = cartService.save(cart);
        if (savedCart == null) {
            throw new BadRequestException("Cart not created");
        }
        return makeResponse(true, cartMapper.toDto(savedCart), "Cart created");
    }

    @Transactional
    // Delete cart by user id
    @DeleteMapping("/{userId}")
    public ApiMessageDto<Object> deleteCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.getByUserId(userId);
        if (cart == null) {
            throw new BadRequestException("Cart not found");
        }
        // Remove all cart items
        cartItemService.deleteAllByCartId(cart.getId());
        cart.setCartItems(null);
        cartService.save(cart);
        return makeResponse(true, null, "Cart deleted");
    }

    // Get card details by user id
    @GetMapping("/{userId}")
    public ApiMessageDto<Object> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.getByUserId(userId);
        if (cart == null) {
            throw new BadRequestException("Cart not found");
        }
        return makeResponse(true, cartMapper.toDto(cart), "Cart retrieved");
    }
}
