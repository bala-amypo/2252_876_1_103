package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import java.time.LocalDate;
import java.util.List;

public class AvailabilityController {
    private final AvailabilityService availabilityService;
    private final EmployeeRepository employeeRepository;

    public AvailabilityController(AvailabilityService availabilityService,
                                 EmployeeRepository employeeRepository) {
        this.availabilityService = availabilityService;
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<List<EmployeeAvailability>> list() {
        return new ResponseEntity<>(availabilityService.getAll());
    }

    public ResponseEntity<List<EmployeeAvailability>> byDate(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return new ResponseEntity<>(availabilityService.getByDate(date));
    }

    public ResponseEntity<EmployeeAvailability> get(Long id) {
        return new ResponseEntity<>(availabilityService.get(id));
    }

    public ResponseEntity<EmployeeAvailability> create(EmployeeAvailability availability) {
        return new ResponseEntity<>(availabilityService.create(availability));
    }

    public ResponseEntity<EmployeeAvailability> update(Long id, EmployeeAvailability availability) {
        return new ResponseEntity<>(availabilityService.update(id, availability));
    }

    public ResponseEntity<String> delete(Long id) {
        availabilityService.delete(id);
        return new ResponseEntity<>("Deleted");
    }

    public static class ResponseEntity<T> {
        private final T body;
        public ResponseEntity(T body) { this.body = body; }
        public T getBody() { return body; }
    }
}