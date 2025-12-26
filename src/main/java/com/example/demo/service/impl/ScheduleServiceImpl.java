package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public List<Employee> scheduleEmployees(List<Employee> employees, String requiredSkill) {

        List<Employee> scheduledEmployees = new ArrayList<>();

        if (employees == null || requiredSkill == null) {
            return scheduledEmployees;
        }

        for (Employee employee : employees) {

            if (employee == null || employee.getSkills() == null) {
                continue;
            }

            // ✅ CORRECT FIX: skills is List<String>, not String
            if (employee.getSkills().contains(requiredSkill)) {
                scheduledEmployees.add(employee);
            }
        }

        return scheduledEmployees;
    }
}
