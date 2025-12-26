package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface ScheduleService {

    List<Employee> scheduleEmployees(List<Employee> employees, String requiredSkill);
}
