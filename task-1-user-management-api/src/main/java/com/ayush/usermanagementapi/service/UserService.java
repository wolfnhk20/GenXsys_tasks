package com.ayush.usermanagementapi.service;

import com.ayush.usermanagementapi.exception.UserNotFoundException;
import com.ayush.usermanagementapi.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class UserService {

    private final Map<UUID, User> userMap = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File storageFile = new File("users.json");

    // load data on startup
    @PostConstruct
    public void loadFromFile() {
        if (!storageFile.exists()) return;
        try {
            List<User> users = objectMapper.readValue(storageFile, new TypeReference<List<User>>() {});
            for (User u : users) {
                if (u.getId() == null) {
                    u.setId(UUID.randomUUID());
                }
                userMap.put(u.getId(), u);
            }
            System.out.println("Loaded " + userMap.size() + " users from users.json");
        } catch (IOException e) {
            System.err.println("Failed to load users.json: " + e.getMessage());
        }
    }

    // save data on shutdown
    @PreDestroy
    public void saveToFile() {
        try {
            List<User> users = new ArrayList<>(userMap.values());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, users);
            System.out.println("Saved " + users.size() + " users to users.json");
        } catch (IOException e) {
            System.err.println("Failed to save users.json: " + e.getMessage());
        }
    }

    // CREATE
    public User createUser(User user) {
        UUID id = UUID.randomUUID();
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    // READ ALL
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    // READ BY ID
    public User getUserById(UUID id) {
        User user = userMap.get(id);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        return user;
    }

    // UPDATE
    public User updateUser(UUID id, User updatedUser) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        updatedUser.setId(id);
        userMap.put(id, updatedUser);
        return updatedUser;
    }

    // DELETE
    public void deleteUser(UUID id) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        userMap.remove(id);
    }
}
