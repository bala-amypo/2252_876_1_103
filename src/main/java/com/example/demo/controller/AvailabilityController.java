package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/availability")
@Tag(name = "Employee Availability Endpoints")
public class EmployeeAvailabilityController {

    @PostMapping
    public String addAvailability() {
        return "Availability Added";
    }

    @GetMapping("/employee/{employeeId}")
    public String getAvailability(@PathVariable Long employeeId) {
        return "Availability for Employee " + employeeId;
    }
}
