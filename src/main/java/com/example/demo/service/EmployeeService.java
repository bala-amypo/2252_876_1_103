package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    // existing
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

    //  REQUIRED BY TESTS
    default Employee createEmployee(Employee employee) {
        return saveEmployee(employee);
    }

    default Employee getEmployee(long id) {
        return getEmployeeById(id);
    }

    default List<Employee> getAll() {
        return getAllEmployees();
    }

    Optional<Employee> findByEmail(String email);
}
