package com.ayush.usermanagementapi.service;

import com.ayush.usermanagementapi.exception.UserNotFoundException;
import com.ayush.usermanagementapi.model.User;
import com.ayush.usermanagementapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public User createUser(User user) {
        user.setId(String.valueOf(UUID.fromString(UUID.randomUUID().toString())));
        return repository.save(user);
    }

    // READ ALL
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // READ BY ID
    public User getUserById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    // UPDATE
    public User updateUser(String id, User updatedUser) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        updatedUser.setId(id);
        return repository.save(updatedUser);
    }

    // DELETE
    public void deleteUser(String id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
