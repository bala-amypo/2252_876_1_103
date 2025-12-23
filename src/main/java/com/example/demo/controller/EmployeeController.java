package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Endpoints")
public class EmployeeController {

    @PostMapping
    public String createEmployee() {
        return "Employee Created";
    }

    @GetMapping
    public String getAllEmployees() {
        return "Employee List";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable Long id) {
        return "Employee " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return "Employee Deleted";
    }
}
