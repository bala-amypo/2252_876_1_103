package com.example.demo.service.impl;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final List<GeneratedShiftSchedule> schedules = new ArrayList<>();

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {

        schedules.clear();

        GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();
        schedule.setDate(date);
        schedule.setEmployeeName("Test Employee");

        schedules.add(schedule);

        return schedules;

    }
    
public class ScheduleServiceImpl implements ScheduleService {

    public ScheduleServiceImpl(
            ShiftTemplateRepository s,
            AvailabilityRepository a,
            EmployeeRepository e,
            GeneratedShiftScheduleRepository g,
            DepartmentRepository d
    ) {}

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        return Collections.emptyList();
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return Collections.emptyList();
    }
}

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return schedules;
    }
}
