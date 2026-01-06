package com.ayush.usermanagementapi.controller;

import com.ayush.usermanagementapi.dto.UserRequest;
import com.ayush.usermanagementapi.dto.UserResponse;
import com.ayush.usermanagementapi.model.User;
import com.ayush.usermanagementapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // map model -> response DTO
    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getAge());
    }

    // map request DTO -> model
    private User toModel(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        return user;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        User created = userService.createUser(toModel(request));
        return new ResponseEntity<>(toResponse(created), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return toResponse(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable String id, @Valid @RequestBody UserRequest request) {
        return toResponse(userService.updateUser(id, toModel(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
