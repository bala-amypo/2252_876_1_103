package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import java.time.LocalDate;
import java.util.List;

public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public ResponseEntity<List<GeneratedShiftSchedule>> generate(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return new ResponseEntity<>(scheduleService.generateForDate(date));
    }

    public ResponseEntity<List<GeneratedShiftSchedule>> byDate(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return new ResponseEntity<>(scheduleService.getByDate(date));
    }

    public static class ResponseEntity<T> {
        private final T body;
        public ResponseEntity(T body) { this.body = body; }
        public T getBody() { return body; }
    }
}