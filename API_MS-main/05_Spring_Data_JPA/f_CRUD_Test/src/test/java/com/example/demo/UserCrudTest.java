package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserCrudTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void executeDatabaseCrudSequence() {
        userRepository.deleteAll();
        System.out.println("\n================= INITIALIZING DATA JPA TESTS =================");

        // 1. CREATE
        User studentA = userRepository.save(new User("John Doe", "john.doe@aditya.edu.in"));
        User studentB = userRepository.save(new User("Alice Smith", "alice.s@aditya.edu.in"));
        System.out.println("[CREATE] Success! Injected persistent models inside H2 database instance context.");

        // 2. READ ALL
        List<User> activeUsers = userRepository.findAll();
        System.out.println("[READ ALL] Displaying existing user schema records below:");
        activeUsers.forEach(System.out::println);
        assertEquals(2, activeUsers.size());

        // 3. UPDATE
        Optional<User> foundUserOpt = userRepository.findById(studentA.getId());
        assertTrue(foundUserOpt.isPresent());
        User existingUser = foundUserOpt.get();
        existingUser.setName("John Developer");
        userRepository.save(existingUser);
        System.out.println("[UPDATE] Success! Synchronized altered fields to record index ID: " + studentA.getId());

        System.out.println("[READ INDIVIDUAL] Verifying changes made to Record index ID " + studentA.getId() + ":");
        userRepository.findById(studentA.getId()).ifPresent(System.out::println);
        assertEquals("John Developer", userRepository.findById(studentA.getId()).get().getName());

        // 4. DELETE
        userRepository.deleteById(studentB.getId());
        System.out.println("[DELETE] Terminated record row corresponding to Identifier Index ID: " + studentB.getId());
        assertFalse(userRepository.findById(studentB.getId()).isPresent());

        long runtimeRecordCount = userRepository.count();
        System.out.println("[COUNT] Remaining Database Row Balance Vector Total: " + runtimeRecordCount);
        assertEquals(1, runtimeRecordCount);

        System.out.println("================== DATA JPA TESTS COMPLETED ==================\n");
    }
}
