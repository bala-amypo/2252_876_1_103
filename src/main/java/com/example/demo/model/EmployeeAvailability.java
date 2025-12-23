package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class EmployeeAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate availableDate;
    private boolean available;

    @ManyToOne
    private Employee employee;

    public EmployeeAvailability() {}

    public Long getId() { return id; }
    public LocalDate getAvailableDate() { return availableDate; }
    public boolean getAvailable() { return available; }
    public Employee getEmployee() { return employee; }

    public void setId(Long id) { this.id = id; }
    public void setAvailableDate(LocalDate availableDate) { this.availableDate = availableDate; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
