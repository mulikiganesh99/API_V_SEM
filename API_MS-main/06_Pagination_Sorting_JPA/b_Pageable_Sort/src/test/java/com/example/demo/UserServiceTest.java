package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void serviceReturnsAscendingSortedPage() {
        userRepository.deleteAll();
        userRepository.save(new User("Zara", "zara@aditya.edu.in"));
        userRepository.save(new User("Aman", "aman@aditya.edu.in"));

        Page<User> page = userService.getUsersPagedAndSorted(0, 2, "name", "ASC");
        assertEquals("Aman", page.getContent().get(0).getName());
        assertEquals("Zara", page.getContent().get(1).getName());
    }
}
