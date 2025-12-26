package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import java.util.List;

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public ResponseEntity<List<Department>> list() {
        return new ResponseEntity<>(departmentService.getAll());
    }

    public ResponseEntity<Department> get(Long id) {
        return new ResponseEntity<>(departmentService.get(id));
    }

    public ResponseEntity<Department> create(Department department) {
        return new ResponseEntity<>(departmentService.create(department));
    }

    public ResponseEntity<Department> update(Long id, Department department) {
        return new ResponseEntity<>(departmentService.update(id, department));
    }

    public ResponseEntity<String> delete(Long id) {
        departmentService.delete(id);
        return new ResponseEntity<>("Deleted");
    }

    public static class ResponseEntity<T> {
        private final T body;
        public ResponseEntity(T body) { this.body = body; }
        public T getBody() { return body; }
    }
}