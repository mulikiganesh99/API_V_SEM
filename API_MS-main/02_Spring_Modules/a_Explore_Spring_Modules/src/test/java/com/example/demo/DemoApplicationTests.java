package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // Confirms Core (IoC container), Data Access (JDBC/H2) and Web modules
        // all initialize together without conflict.
    }
}
