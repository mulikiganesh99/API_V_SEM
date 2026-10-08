package com.example.demo.service;

import com.example.demo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private Employee employee;

    public void logDetails() {
        logger.info("Executing operational details logging statement via Logback context.");
        logger.info("Injected Object Reference Content: {}", employee.toString());
    }
}
