package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(
    name = "shift_templates",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"templateName", "department_id"})
    }
)
public class ShiftTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String templateName;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private String requiredSkills;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public ShiftTemplate() {}

    // getters and setters
}