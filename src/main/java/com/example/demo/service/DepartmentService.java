package com.example.demo.service;

import com.example.demo.model.Department;
import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();
}
