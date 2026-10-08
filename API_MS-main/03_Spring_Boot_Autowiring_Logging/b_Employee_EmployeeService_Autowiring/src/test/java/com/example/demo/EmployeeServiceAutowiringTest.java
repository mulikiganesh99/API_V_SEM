package com.example.demo;

import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EmployeeServiceAutowiringTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void employeeIsAutowiredIntoService() {
        String details = employeeService.getEmployeeDetails();
        assertTrue(details.contains("Dependency Injection Successful"));
        assertTrue(details.contains("Aditya Software Engineer"));
    }
}
