package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import java.time.LocalDate;
import java.util.List;

public class AvailabilityServiceImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository,
                                  EmployeeRepository employeeRepository) {
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeAvailability create(EmployeeAvailability availability) {
        if (availabilityRepository.findByEmployee_IdAndAvailableDate(
                availability.getEmployee().getId(), availability.getAvailableDate()).isPresent()) {
            throw new RuntimeException("Availability for this employee and date already exists");
        }
        return availabilityRepository.save(availability);
    }

    @Override
    public EmployeeAvailability get(Long id) {
        return availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
    }

    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability) {
        EmployeeAvailability existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        
        existing.setAvailable(availability.getAvailable());
        existing.setAvailableDate(availability.getAvailableDate());
        
        return availabilityRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        EmployeeAvailability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        availabilityRepository.delete(availability);
    }

    @Override
    public List<EmployeeAvailability> getAll() {
        return availabilityRepository.findAll();
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return availabilityRepository.findByAvailableDateAndAvailable(date, true);
    }
}