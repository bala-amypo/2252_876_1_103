package com.example.demo.model;

import java.util.List;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private List<String> skills;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String role, int dummy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    // ✅ REQUIRED getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public String getRole() { return role; }

    public List<String> getSkills() { return skills; }

    public void setFullName(String name) {
        String[] p = name.split(" ");
        this.firstName = p[0];
        this.lastName = p.length > 1 ? p[1] : "";
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
