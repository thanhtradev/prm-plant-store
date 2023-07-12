package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.CartDto;
import com.prmplantstore.app.resDto.CartItemCreatedDto;
import com.prmplantstore.entities.Cart;
import com.prmplantstore.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CartMapper extends EntityDtoMapper<CartDto, Cart> {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "cartItemIds", expression = "java(mapCartItemIds(cart.getCartItems()))")
    CartDto toDto(Cart cart);

    default List<Long> mapCartItemIds(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(CartItem::getId)
                .collect(Collectors.toList());
    }
}
