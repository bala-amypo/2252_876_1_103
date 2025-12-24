package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployee(id);

        existing.setFullName(employee.getFullName());
        existing.setEmail(employee.getEmail());
        existing.setSkills(employee.getSkills());
        existing.setMaxWeeklyHours(employee.getMaxWeeklyHours());
        existing.setRole(employee.getRole());

        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
