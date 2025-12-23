package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Shift Schedule Endpoints")
public class ScheduleController {

    @PostMapping("/{date}")
    public String generateSchedule(@PathVariable String date) {
        return "Schedule generated for " + date;
    }

    @GetMapping("/{date}")
    public String getSchedule(@PathVariable String date) {
        return "Schedule for " + date;
    }
}
