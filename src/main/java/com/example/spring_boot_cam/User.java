package com.example.spring_boot_cam;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List; // Import this

/* specificy which collection in our database we are using */
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;

    // Constructors, getters, setters
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
