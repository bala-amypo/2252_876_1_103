package com.example.demo.dto;

public class AvailabilityDto {

    private boolean available;

    public AvailabilityDto() {
    }

    public AvailabilityDto(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
