package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.service.StudentService;

@SpringBootApplication
// Forces the context runtime tracking engine to scan components tagged with @Aspect
// and create AOP proxies for advised beans (StudentService in this case).
@EnableAspectJAutoProxy
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentService studentService) {
        return args -> {
            studentService.displayStudentDetails();
            studentService.updateStudentName("Alice Smith");
        };
    }
}
