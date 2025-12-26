package com.example.demo.service.impl;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    // ✅ Constructor REQUIRED by tests
    public ScheduleServiceImpl(
            ShiftTemplateRepository shiftTemplateRepository,
            AvailabilityRepository availabilityRepository,
            EmployeeRepository employeeRepository,
            GeneratedShiftScheduleRepository generatedShiftScheduleRepository,
            DepartmentRepository departmentRepository
    ) {
    }

    // ✅ No-args constructor (Spring)
    public ScheduleServiceImpl() {
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        return new ArrayList<>();
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return new ArrayList<>();
    }
}
