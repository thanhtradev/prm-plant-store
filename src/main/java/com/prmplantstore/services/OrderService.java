package com.prmplantstore.services;

import com.prmplantstore.entities.Order;
import com.prmplantstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }
    public Boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    public List<Order> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
