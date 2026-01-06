package com.ayush.usermanagementapi.service;

import com.ayush.usermanagementapi.model.User;
import com.ayush.usermanagementapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        if (repo.count() == 0)
            user.setRole("ADMIN");
        else
            user.setRole("USER");

        return repo.save(user);
    }

    public User login(String email, String password) {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!encoder.matches(password, user.getPassword()))
            throw new RuntimeException("Invalid password");

        return user;
    }
}
