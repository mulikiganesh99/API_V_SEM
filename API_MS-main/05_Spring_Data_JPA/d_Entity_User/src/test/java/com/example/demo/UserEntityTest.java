package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserEntityTest {

    @Test
    void constructorAndAccessorsWork() {
        User user = new User("Test User", "test@aditya.edu.in");
        assertEquals("Test User", user.getName());
        assertEquals("test@aditya.edu.in", user.getEmail());
    }
}
