package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // Field injection is used here (via @Autowired) to explicitly demonstrate
    // the @Autowired annotation as required by this lab exercise. In
    // production code, constructor injection is generally preferred for
    // testability and immutability.
    @Autowired
    private Employee employee;

    public String getEmployeeDetails() {
        return "Dependency Injection Successful: " + employee.toString();
    }
}
