package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserPaginationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setupMockDatabaseData() {
        userRepository.deleteAll();
        userRepository.saveAll(Arrays.asList(
                new User("Rahul Kumar", "rahul@aditya.edu.in"),
                new User("Ananya Sen", "ananya@aditya.edu.in"),
                new User("Vijay Sharma", "vijay@aditya.edu.in"),
                new User("Bhavana Reddy", "bhavana@aditya.edu.in"),
                new User("Deepak Verma", "deepak@aditya.edu.in")
        ));
    }

    @Test
    public void testPaginationAndSortingExecution() {
        System.out.println("\n--- STARTING PAGINATION AND SORTING VERIFICATION TEST ---");

        int pageNo = 0;
        int pageSize = 3;
        Page<User> userPage = userService.getUsersPagedAndSorted(pageNo, pageSize, "name", "ASC");

        System.out.println("[PAGINATION] Total Elements found in H2 Store: " + userPage.getTotalElements());
        System.out.println("[PAGINATION] Total Pages compiled via segment metrics: " + userPage.getTotalPages());
        System.out.println("[PAGINATION] Content elements inside current window (Page " + pageNo + "):");
        userPage.getContent().forEach(user ->
                System.out.println(" -> Name: " + user.getName() + " | Email: " + user.getEmail()));

        assertEquals(5, userPage.getTotalElements());
        assertEquals(2, userPage.getTotalPages());
        assertEquals(3, userPage.getContent().size());
        assertEquals("Ananya Sen", userPage.getContent().get(0).getName());

        System.out.println("--- PAGINATION AND SORTING VERIFICATION TEST COMPLETED ---\n");
    }
}
