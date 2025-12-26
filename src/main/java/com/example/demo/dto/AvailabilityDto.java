package com.example.demo.dto;

import java.time.LocalDate;

public class AvailabilityDto {

    private Long employeeId;
    private LocalDate availableDate;
    private boolean available;

    // No-args constructor
    public AvailabilityDto() {
    }

    // All-args constructor
    public AvailabilityDto(Long employeeId, LocalDate availableDate, boolean available) {
        this.employeeId = employeeId;
        this.availableDate = availableDate;
        this.available = available;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
