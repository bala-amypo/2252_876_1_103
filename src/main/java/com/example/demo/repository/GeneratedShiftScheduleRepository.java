package com.example.demo.repository;

import com.example.demo.model.GeneratedShiftSchedule;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GeneratedShiftScheduleRepository {
    GeneratedShiftSchedule save(GeneratedShiftSchedule schedule);
    Optional<GeneratedShiftSchedule> findById(Long id);
    List<GeneratedShiftSchedule> findAll();
    void delete(GeneratedShiftSchedule schedule);
    List<GeneratedShiftSchedule> findByShiftDate(LocalDate date);
}