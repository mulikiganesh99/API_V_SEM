package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryPagingTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAllWithPageableReturnsAPage() {
        userRepository.deleteAll();
        userRepository.save(new User("A", "a@aditya.edu.in"));
        userRepository.save(new User("B", "b@aditya.edu.in"));

        Page<User> page = userRepository.findAll(PageRequest.of(0, 1));
        assertTrue(page.getTotalElements() >= 2);
        assertTrue(page.getContent().size() == 1);
    }
}
