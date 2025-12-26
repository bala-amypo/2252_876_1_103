package com.example.demo.dto;

import java.time.LocalDate;

public class AvailabilityDto {

    private LocalDate availableDate;

    public AvailabilityDto() {}

    public AvailabilityDto(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
}
package com.example.demo.service.impl;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

