package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.OrderItemDto;
import com.prmplantstore.entities.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper extends EntityDtoMapper<OrderItemDto, OrderItem>{
}
