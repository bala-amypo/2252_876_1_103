package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class ShiftTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;

    @ElementCollection
    private Set<String> requiredSkills;

    @ManyToOne
    private Department department;

    public ShiftTemplate() {}

    public String getTemplateName() { return templateName; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public Set<String> getRequiredSkills() { return requiredSkills; }
    public Department getDepartment() { return department; }

    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setRequiredSkills(Set<String> requiredSkills) { this.requiredSkills = requiredSkills; }
    public void setDepartment(Department department) { this.department = department; }
}
