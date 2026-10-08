package com.example.demo;

import com.example.demo.model.SoapUser;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void getUserByIdReturnsSeededUser() {
        SoapUser user = userService.getUserById(1L);
        assertEquals("Rahul Kumar", user.getName());
        assertEquals("rahul@aditya.edu.in", user.getEmail());
    }

    @Test
    void getUserByIdReturnsNullForUnknownId() {
        assertNull(userService.getUserById(999L));
    }
}
