package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String employeeName;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
