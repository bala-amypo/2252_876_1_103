package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "employee_availability",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_id", "availableDate"})
    }
)
public class EmployeeAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private LocalDate availableDate;

    @Column(nullable = false)
    private Boolean available;

    public EmployeeAvailability() {}

    // getters and setters
}