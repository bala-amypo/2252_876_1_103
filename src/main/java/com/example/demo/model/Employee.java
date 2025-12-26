package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private int experience;

    @ElementCollection
    private List<String> skills;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, String role, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
