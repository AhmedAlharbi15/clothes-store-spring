package com.isb.clothes.store.modules.clothes.service;

import com.isb.clothes.store.modules.clothes.entity.User;
import com.isb.clothes.store.modules.clothes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");

        }
        return userRepository.save(user);
    }
    public User loginUser(String email,String password){
        return userRepository.findByEmail(email).filter(user -> user.getPassword().equals(password)).orElseThrow(()-> new RuntimeException("Invalid credentials"));

    }
}
