package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<User> userList = new ArrayList<>();
    private long currentId = 1;

    public UserController() {
        userList.add(new User(currentId++, "Rahul Kumar", "rahul@aditya.edu.in"));
        userList.add(new User(currentId++, "Ananya Sen", "ananya@aditya.edu.in"));
    }

    // 1. READ ALL - HTTP GET
    @GetMapping
    public List<User> getAllUsers() {
        return userList;
    }

    // 2. READ BY ID - HTTP GET
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREATE - HTTP POST
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        newUser.setId(currentId++);
        userList.add(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // 4. UPDATE - HTTP PUT
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUserData) {
        Optional<User> existingUserOpt = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        if (existingUserOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = existingUserOpt.get();
        existingUser.setName(updatedUserData.getName());
        existingUser.setEmail(updatedUserData.getEmail());
        return ResponseEntity.ok(existingUser);
    }

    // 5. DELETE - HTTP DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean removed = userList.removeIf(user -> user.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("User record matching Index identifier ID " + id + " has been completely removed.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User Record Index ID: " + id + " not found!");
    }
}
