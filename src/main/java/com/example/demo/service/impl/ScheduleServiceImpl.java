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

    private final ShiftTemplateRepository templateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(
            ShiftTemplateRepository templateRepository,
            AvailabilityRepository availabilityRepository,
            GeneratedShiftScheduleRepository scheduleRepository
    ) {
        this.templateRepository = templateRepository;
        this.availabilityRepository = availabilityRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {

        List<ShiftTemplate> templates = templateRepository.findAll();
        List<EmployeeAvailability> availableEmployees =
                availabilityRepository.findByAvailableDateAndAvailable(date, true);

        List<GeneratedShiftSchedule> result = new ArrayList<>();

        for (ShiftTemplate template : templates) {
            for (EmployeeAvailability availability : availableEmployees) {

                Employee employee = availability.getEmployee();

                if (employee.getSkills().contains(template.getRequiredSkills())) {
                    GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();
                    schedule.setShiftDate(date);
                    schedule.setStartTime(template.getStartTime());
                    schedule.setEndTime(template.getEndTime());
                    schedule.setEmployee(employee);
                    schedule.setDepartment(template.getDepartment());
                    schedule.setShiftTemplate(template);

                    result.add(scheduleRepository.save(schedule));
                    break;
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
