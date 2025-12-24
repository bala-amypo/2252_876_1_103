package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private int maxWeeklyHours;

    @ElementCollection
    private Set<String> skills;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, STAFF
    }

    public Employee() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getMaxWeeklyHours() { return maxWeeklyHours; }
    public void setMaxWeeklyHours(int maxWeeklyHours) {
        this.maxWeeklyHours = maxWeeklyHours;
    }

    public Set<String> getSkills() { return skills; }
    public Set<String> getSkillsSet() { return skills; }
    public void setSkills(Set<String> skills) { this.skills = skills; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
