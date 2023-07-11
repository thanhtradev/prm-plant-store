package com.prmplantstore.services;

import com.prmplantstore.entities.User;
import com.prmplantstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Generated code: save, deleteById, getById, findAll, findAllById, count, existsById, deleteAll, delete, saveAll
    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    public Long count() {
        return userRepository.count();
    }

    public Boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    public Boolean existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Iterable<User> saveAll(Iterable<User> users) {
        return userRepository.saveAll(users);
    }



}
