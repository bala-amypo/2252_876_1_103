package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Department department;

    @ManyToOne
    private ShiftTemplate shiftTemplate;
}
