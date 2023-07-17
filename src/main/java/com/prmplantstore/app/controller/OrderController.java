package com.prmplantstore.app.controller;

import com.prmplantstore.app.mapper.OrderMapper;
import com.prmplantstore.app.reqDto.OrderCreatedDto;
import com.prmplantstore.app.reqDto.OrderItemDto;
import com.prmplantstore.app.resDto.DetailOrderDto;
import com.prmplantstore.app.resDto.DetailOrderItemDto;
import com.prmplantstore.common.BaseController;
import com.prmplantstore.entities.*;
import com.prmplantstore.exception.BadRequestException;
import com.prmplantstore.model.dto.ApiMessageDto;
import com.prmplantstore.services.OrderService;
import com.prmplantstore.services.PlantService;
import com.prmplantstore.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private PlantService plantService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    public ApiMessageDto<Object> createOrder(@Valid @RequestBody OrderCreatedDto orderCreatedDto) {
        // Check if user is existed
        // Check if plant is existed
        // Check if plant is available
        // Check if plant quantity is enough
        if (!userService.existsById(orderCreatedDto.getUserId())) {
            throw new BadRequestException("User is not existed");
        }
        User user = userService.getById(orderCreatedDto.getUserId());
        Order order = new Order();
        order.setOrderItems(new ArrayList<>());
        order.setUser(user);
        order.setDate(Date.from(new Date().toInstant()));
        order.setStatus(EOrderStatus.PENDING);
        for (OrderItemDto orderItemDto : orderCreatedDto.getOrderItems()) {
            if (!plantService.existsById(orderItemDto.getPlantId())) {
                throw new BadRequestException("Plant is not existed");
            }
            Plant plant = plantService.getById(orderItemDto.getPlantId());
            if (plant.getAmount() < orderItemDto.getQuantity()) {
                throw new BadRequestException("Plant is not enough");
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setPlant(plant);
            orderItem.setQuantity(orderItemDto.getQuantity());
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
        }
        // Sum total price
        double totalPrice = 0.0;
        for (OrderItem orderItem : order.getOrderItems()) {
            totalPrice += orderItem.getPlant().getPrice() * orderItem.getQuantity();
        }
        order.setTotal(totalPrice);
        Order savedOrder = orderService.save(order);
        return makeResponse(true, orderMapper.toDto(savedOrder), "Order created successfully");
    }
    @GetMapping("/get/{id}")
    public ApiMessageDto<Object> getOrder(@PathVariable("id") Long id) {
        if (!orderService.existsById(id)) {
            throw new BadRequestException("Order is not existed");
        }
        Order order = orderService.getById(id);
        DetailOrderDto detailOrderDto =  modelMapper.map(order, DetailOrderDto.class);
        List<DetailOrderItemDto> detailOrderItemDtos = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()) {
            DetailOrderItemDto detailOrderItemDto = modelMapper.map(orderItem, DetailOrderItemDto.class);
            detailOrderItemDtos.add(detailOrderItemDto);
        }
        detailOrderDto.setOrderItems(detailOrderItemDtos);
        return makeResponse(true, detailOrderDto, "Order retrieved successfully");
    }
}
