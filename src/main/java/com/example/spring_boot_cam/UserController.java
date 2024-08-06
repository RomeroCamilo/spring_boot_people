package com.example.spring_boot_cam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List; // Import this


@RestController
@RequestMapping("/users")
public class UserController {

    /* will contain our built-in functions */
    @Autowired
    private UserRepository userRepository;


    /* POST REQUESTS */
    // POST request to add user
    /* example command in the terminal...
                  curl -X POST \
              http://localhost:8080/users/add \
              -H "Content-Type: application/json" \
              -d '{
                    "name": "John",
                    "email": "john.doe1@example.com"
                  }'
     */
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    /* GET REQUESTS */
    // GET request user by name
    @GetMapping("/byname/{name}")
    public User getUserByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    // GET request user by name
    @GetMapping("/byid/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable String id) {
        return userRepository.findById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET request, get all users in mongo db non JSON.
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET request Endpoint to get all user names as JSON for index.html
    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllUserNames() {
        List<String> names = userRepository.findAll().stream()
                .map(User::getName)
                .toList();
        return ResponseEntity.ok(names);
    }

}
