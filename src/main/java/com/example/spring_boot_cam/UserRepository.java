package com.example.spring_boot_cam;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    // Optionally, you can define custom query methods here if needed
    // Spring Data MongoDB will provide implementation for these methods at runtime

    // Example of a custom query method:
    User findByName(String name);

}