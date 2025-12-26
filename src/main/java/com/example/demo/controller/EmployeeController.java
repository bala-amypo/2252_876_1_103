package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import java.util.List;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public ResponseEntity<List<Employee>> list() {
        return new ResponseEntity<>(employeeService.getAll());
    }

    public ResponseEntity<Employee> get(Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id));
    }

    public ResponseEntity<Employee> create(Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee));
    }

    public ResponseEntity<Employee> update(Long id, Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employee));
    }

    public ResponseEntity<String> delete(Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted");
    }

    public static class ResponseEntity<T> {
        private final T body;
        public ResponseEntity(T body) { this.body = body; }
        public T getBody() { return body; }
    }
}