package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.CartItemDto;
import com.prmplantstore.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper extends  EntityDtoMapper<CartItemDto, CartItem> {
    @Mapping(target = "plantId", source = "plant.id")
    @Mapping(target = "cartId", source = "cart.id")
    CartItemDto toDto(CartItem cartItem);
}
