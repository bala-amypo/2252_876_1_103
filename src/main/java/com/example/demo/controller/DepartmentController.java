package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Department Endpoints")
public class DepartmentController {

    @PostMapping
    public String createDepartment() {
        return "Department Created";
    }

    @GetMapping
    public String getDepartments() {
        return "Department List";
    }

    @GetMapping("/{id}")
    public String getDepartment(@PathVariable Long id) {
        return "Department " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return "Department Deleted";
    }
}
