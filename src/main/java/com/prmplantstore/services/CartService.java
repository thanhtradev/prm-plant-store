package com.prmplantstore.services;

import com.prmplantstore.entities.Cart;
import com.prmplantstore.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    // Generated code: save, deleteById, getById, findAll, findAllById, count, existsById, deleteAll, delete, saveAll
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart getById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public  Cart getByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Iterable<Cart> findAllById(Iterable<Long> ids) {
        return cartRepository.findAllById(ids);
    }

    public Long count() {
        return cartRepository.count();
    }

    public Boolean existsById(Long id) {
        return cartRepository.existsById(id);
    }

    public void deleteAll() {
        cartRepository.deleteAll();
    }

    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }


}
