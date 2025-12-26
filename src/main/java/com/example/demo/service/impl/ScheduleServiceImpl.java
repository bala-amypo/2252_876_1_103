
package com.example.demo.service.impl;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

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


