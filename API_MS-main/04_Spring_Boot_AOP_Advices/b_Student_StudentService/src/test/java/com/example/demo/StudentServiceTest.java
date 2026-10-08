package com.example.demo;

import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void displayAndUpdateRunWithoutError() {
        studentService.displayStudentDetails();
        studentService.updateStudentName("Alice Smith");
        studentService.displayStudentDetails();
    }
}
