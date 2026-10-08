package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

    private Long id = 250101L;
    private String name = "Aditya Software Engineer";
    private String department = "AI & ML Development";

    public Employee() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Dept=" + department + "]";
    }
}
