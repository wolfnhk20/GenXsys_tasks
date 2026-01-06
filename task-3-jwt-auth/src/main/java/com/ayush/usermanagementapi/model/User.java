package com.ayush.usermanagementapi.model;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank(message = "Name required")
    private String name;

    @NotBlank(message = "Email required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password required")
    private String password;

    @NotNull(message = "Age required")
    @Positive(message = "Age must be > 0")
    private Integer age;

    private String role;

    public User() {}

    // getters & setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
