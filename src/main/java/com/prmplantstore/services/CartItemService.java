package com.prmplantstore.services;

import com.prmplantstore.entities.CartItem;
import com.prmplantstore.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    // Generated code: save, deleteById, getById, findAll, findAllById, count, existsById, deleteAll, delete, saveAll

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }

    public CartItem getById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public CartItem getByCartIdAndPlantId(Long cartId, Long plantId) {
        return cartItemRepository.getByCartIdAndPlantId(cartId, plantId);
    }

    public Iterable<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public Iterable<CartItem> findAllById(List<Long> ids) {
        return cartItemRepository.findAllById(ids);
    }

    public Long count() {
        return cartItemRepository.count();
    }

    public Boolean existsById(Long id) {
        return cartItemRepository.existsById(id);
    }

    public Boolean existsByCartIdAndPlantId(Long cartId, Long plantId) {
        return cartItemRepository.existsByCartIdAndPlantId(cartId, plantId);
    }
    public void deleteAll() {
        cartItemRepository.deleteAll();
    }

    public void delete(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public void deleteAllByCartId(Long cartId) {
        cartItemRepository.deleteAllByCartId(cartId);
    }
}
