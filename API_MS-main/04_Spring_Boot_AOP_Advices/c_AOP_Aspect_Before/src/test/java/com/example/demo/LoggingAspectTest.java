package com.example.demo;

import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoggingAspectTest {

    @Autowired
    private StudentService studentService;

    @Test
    void beforeAdviceFiresOnServiceCall() {
        // If the aspect is correctly woven in, calling displayStudentDetails() will also
        // print an "[AOP-BEFORE]" line before the service's own output — visible on the console.
        studentService.displayStudentDetails();
    }
}
