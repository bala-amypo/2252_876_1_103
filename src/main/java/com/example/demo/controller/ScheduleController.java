package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/generate/{date}")
    public ResponseEntity<List<GeneratedShiftSchedule>> generate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(scheduleService.generateForDate(date));
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<GeneratedShiftSchedule>> get(@PathVariable LocalDate date) {
        return ResponseEntity.ok(scheduleService.getByDate(date));
    }
}
