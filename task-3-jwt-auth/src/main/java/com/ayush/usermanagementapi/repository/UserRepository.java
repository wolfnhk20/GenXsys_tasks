package com.ayush.usermanagementapi.repository;

import com.ayush.usermanagementapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}


