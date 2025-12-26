package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getMaxWeeklyHours() == null || employee.getMaxWeeklyHours() <= 0) {
            throw new RuntimeException("Invalid weekly hours");
        }

        if (employee.getRole() == null) {
            employee.setRole("STAFF");
        }

        return repo.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = getEmployee(id);

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setRole(updated.getRole());
        existing.setSkills(updated.getSkills());
        existing.setMaxWeeklyHours(updated.getMaxWeeklyHours());

        return repo.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
