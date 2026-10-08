package com.example.demo;

import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceLoggingTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void logDetailsRunsWithoutException() {
        // logDetails() writes through SLF4J -> Logback (configured by logback-spring.xml).
        // A clean run with no exception confirms both wiring and logging configuration are valid.
        employeeService.logDetails();
    }
}
