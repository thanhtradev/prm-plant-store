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
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-item")
@Tag(name = "Cart Item", description = "The cart item API")
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
        Cart cart = cartService.getByUserId(cartItemCreatedDto.getUserId());
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
            cartItem = new CartItem();
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

    @GetMapping("/{id}")
    public ApiMessageDto<Object> getCartItemById(@PathVariable Long id) {
        CartItem cartItem = cartItemService.getById(id);
        if (cartItem == null) {
            throw new BadRequestException("Cart item not found");
        }
        return makeResponse(true, cartItemMapper.toDto(cartItem), "Cart item found");
    }
    // Get list cart item by list of id
    @GetMapping("/list/{ids}")
    public ApiMessageDto<Object> getListCartItemByIds(@PathVariable String ids) {
        // Split string and parse long to list
        List<Long> idList = parseStringToListLong(ids);
        List<CartItem> cartItems =(List<CartItem>) cartItemService.findAllById(idList);
        return makeResponse(true, cartItemMapper.toDtoList(cartItems), "Cart item found");
    }
    private List<Long> parseStringToListLong(String ids) {
        String[] idArray = ids.split(",");
        List<Long> idList = new java.util.ArrayList<>();
        for (String id : idArray) {
            idList.add(Long.parseLong(id));
        }
        return idList;
    }
}
