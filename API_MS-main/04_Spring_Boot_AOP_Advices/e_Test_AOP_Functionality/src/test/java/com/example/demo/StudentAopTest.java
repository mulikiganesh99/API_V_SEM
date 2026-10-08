package com.example.demo;

import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentAopTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testAopAdviceInterception() {
        System.out.println("====== SYSTEM TEST INITIALIZATION ======");
        // Triggers advice interception hook immediately before standard execution block running
        studentService.displayStudentDetails();
        System.out.println("=========================================");
        // Confirms advice runtime layer intercepts parameter operations seamlessly
        studentService.updateStudentName("Alice Smith");
        System.out.println("========= SYSTEM TEST COMPLETED =========");
    }
}
