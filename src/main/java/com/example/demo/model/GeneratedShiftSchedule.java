
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate shiftDate;

    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }
}