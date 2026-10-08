package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private Student student;

    public void displayStudentDetails() {
        System.out.println("[Service Method] Core logic: Student name is " + student.getName()
                + " with Roll Series: " + student.getRollNo());
    }

    public void updateStudentName(String newName) {
        System.out.println("[Service Method] Core logic: Modifying current name fields to: " + newName);
        student.setName(newName);
    }
}
