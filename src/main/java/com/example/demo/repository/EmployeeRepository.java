package com.example.demo.repository;

import com.example.demo.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    void delete(Employee employee);
    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);
}