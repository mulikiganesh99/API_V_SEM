package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserCustomQueryTest {

    @Autowired
    private UserRepository userRepository;

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
    public void testCustomQuerySortingExecution() {
        System.out.println("\n--- STARTING CUSTOM @QUERY SORTING VERIFICATION TEST ---");

        Sort descSortOrder = Sort.by(Sort.Direction.DESC, "name");
        List<User> customSortedList = userRepository.findAllUsersCustomSorted(descSortOrder);

        System.out.println("[@QUERY SORT] Fetching raw output mapping results directly down below:");
        customSortedList.forEach(user ->
                System.out.println(" -> Name: " + user.getName() + " | Email: " + user.getEmail()));

        assertEquals(5, customSortedList.size());
        assertEquals("Vijay Sharma", customSortedList.get(0).getName());
        assertEquals("Ananya Sen", customSortedList.get(customSortedList.size() - 1).getName());

        System.out.println("--- CUSTOM @QUERY SORTING VERIFICATION TEST COMPLETED ---\n");
    }
}
