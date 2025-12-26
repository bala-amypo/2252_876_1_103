package com.example.demo.service;

import com.example.demo.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {

    // existing method
    List<Employee> scheduleEmployees(List<Employee> employees, String requiredSkill);

    // ✅ REQUIRED by controller
    void generateForDate(LocalDate date);

    List<Employee> getByDate(LocalDate date);
}
