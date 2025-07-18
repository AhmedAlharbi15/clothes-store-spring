package com.isb.clothes.store.modules.clothes.controller;

import com.isb.clothes.store.modules.clothes.entity.User;
import com.isb.clothes.store.modules.clothes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("clothes/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String , String> credntials){
        try {
            String email = credntials.get("email");
            String password=credntials.get("password");
            User user =userService.loginUser(email,password);
            return ResponseEntity.ok("Login successful for:"+user.getName());

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed:" + e.getMessage());
        }
    }
}
