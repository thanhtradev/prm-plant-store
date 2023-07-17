package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.OrderDto;
import com.prmplantstore.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityDtoMapper<OrderDto, Order> {
    @Mapping(target = "userId", source = "user.id")
    OrderDto toDto(Order order);
}
