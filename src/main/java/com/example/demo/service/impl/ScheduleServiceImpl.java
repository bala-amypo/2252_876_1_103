package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ShiftTemplateRepository shiftTemplateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;
    private final DepartmentRepository departmentRepository;

    public ScheduleServiceImpl(
            ShiftTemplateRepository shiftTemplateRepository,
            AvailabilityRepository availabilityRepository,
            EmployeeRepository employeeRepository,
            GeneratedShiftScheduleRepository scheduleRepository,
            DepartmentRepository departmentRepository
    ) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> result = new ArrayList<>();

        for (Department dept : departmentRepository.findAll()) {
            for (ShiftTemplate st : shiftTemplateRepository.findByDepartment_Id(dept.getId())) {
                for (EmployeeAvailability av :
                        availabilityRepository.findByAvailableDateAndAvailable(date, true)) {

                    if (av.getEmployee().getSkills().contains(st.getRequiredSkills())) {
                        GeneratedShiftSchedule g = new GeneratedShiftSchedule();
                        g.setEmployee(av.getEmployee());
                        g.setShiftTemplate(st);
                        g.setShiftDate(date);
                        result.add(scheduleRepository.save(g));
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}
