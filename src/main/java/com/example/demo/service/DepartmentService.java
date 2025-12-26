package com.example.demo.service;

import com.example.demo.model.Department;
import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);

    //  REQUIRED BY TESTS
    default Department create(Department department) {
        return saveDepartment(department);
    }

    default Department get(long id) {
        return getDepartmentById(id);
    }

    default List<Department> getAll() {
        return getAllDepartments();
    }

    default void delete(long id) {
        deleteDepartment(id);
    }
}
