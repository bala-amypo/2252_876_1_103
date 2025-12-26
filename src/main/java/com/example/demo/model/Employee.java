package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @ElementCollection
    private List<String> skills;

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
