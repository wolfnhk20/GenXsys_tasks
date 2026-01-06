package com.ayush.usermanagementapi.controller;

import com.ayush.usermanagementapi.model.User;
import com.ayush.usermanagementapi.service.AuthService;
import com.ayush.usermanagementapi.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User u = authService.login(user.getEmail(), user.getPassword());
        String token = jwtUtil.generateToken(u.getEmail(), u.getRole());
        return Map.of("token", token);
    }
}
