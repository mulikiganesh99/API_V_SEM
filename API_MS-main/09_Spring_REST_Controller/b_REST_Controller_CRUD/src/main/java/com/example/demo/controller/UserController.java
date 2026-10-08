package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> userList = new ArrayList<>();
    private long currentId = 1;

    public UserController() {
        userList.add(new User(currentId++, "Rahul Kumar", "rahul@aditya.edu.in"));
        userList.add(new User(currentId++, "Ananya Sen", "ananya@aditya.edu.in"));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        newUser.setId(currentId++);
        userList.add(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedData) {
        Optional<User> existingOpt = userList.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User existing = existingOpt.get();
        existing.setName(updatedData.getName());
        existing.setEmail(updatedData.getEmail());
        return ResponseEntity.ok(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean removed = userList.removeIf(u -> u.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found.");
    }
}
