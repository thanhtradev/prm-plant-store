package com.prmplantstore.app.mapper;

import com.prmplantstore.app.dto.OrderDto;
import com.prmplantstore.entities.CartItem;
import com.prmplantstore.entities.Order;
import com.prmplantstore.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityDtoMapper<OrderDto, Order> {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "orderItemIds", expression = "java(mapOrderItemIds(order.getOrderItems()))")
    OrderDto toDto(Order order);

    default List<Long> mapOrderItemIds(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem::getId)
                .collect(Collectors.toList());
    }
}
