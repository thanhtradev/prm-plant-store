package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.CartItemMapper;
import com.prmplantstore.app.resDto.CartItemCreatedDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.Cart;
import com.prmplantstore.entities.CartItem;
import com.prmplantstore.entities.Plant;
import com.prmplantstore.exception.BadRequestException;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.CartItemService;
import com.prmplantstore.services.CartService;
import com.prmplantstore.services.PlantService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart-item")
public class CartItemController extends BaseController {
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private PlantService plantService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CartItemMapper cartItemMapper;

    // Add cart item to cart
    @PostMapping()
    public ApiMessageDto<Object> addCartItemToCart(@Valid @RequestBody CartItemCreatedDto cartItemCreatedDto) {
        Cart cart = cartService.getById(cartItemCreatedDto.getCartId());
        if (cart == null) {
            throw new BadRequestException("Cart not found");
        }

        Plant plant = plantService.getById(cartItemCreatedDto.getPlantId());
        if (plant == null) {
            throw new BadRequestException("Plant not found");
        }
        CartItem cartItem;
        if (cartItemService.existsByCartIdAndPlantId(cart.getId(), plant.getId())) {
            cartItem = cartItemService.getByCartIdAndPlantId(cart.getId(), plant.getId());
            cartItem.setAmount(cartItem.getAmount() + 1);
        } else {
            cartItem = modelMapper.map(cartItemCreatedDto, CartItem.class);
            cartItem.setCart(cart);
            cartItem.setPlant(plant);
            cartItem.setAmount(cartItemCreatedDto.getAmount());
        }
        cartItem = cartItemService.save(cartItem);
        return makeResponse(true, cartItemMapper.toDto(cartItem), "Cart item added");
    }

    // Delete cart item by cart id and plant id
    @DeleteMapping("/delete/{cartId}/{plantId}")
    public ApiMessageDto<Object> deleteCartItem(@PathVariable("cartId") Long cartId, @PathVariable("plantId") Long plantId) {
        CartItem cartItem = cartItemService.getByCartIdAndPlantId(cartId, plantId);
        if (cartItem == null) {
            throw new BadRequestException("Cart item not found");
        }
        cartItemService.delete(cartItem);
        return makeResponse(true, null, "Cart item deleted");
    }
}
