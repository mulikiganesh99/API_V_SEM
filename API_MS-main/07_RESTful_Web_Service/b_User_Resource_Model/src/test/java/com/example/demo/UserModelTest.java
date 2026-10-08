package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserModelTest {

    @Test
    void constructorAndAccessorsWork() {
        User user = new User(1L, "Test", "test@aditya.edu.in");
        assertEquals(1L, user.getId());
        assertEquals("Test", user.getName());
        assertEquals("test@aditya.edu.in", user.getEmail());
    }
}
