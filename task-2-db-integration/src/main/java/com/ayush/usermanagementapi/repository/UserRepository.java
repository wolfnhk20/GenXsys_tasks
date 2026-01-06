package com.ayush.usermanagementapi.repository;

import com.ayush.usermanagementapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {
}
