package com.example.demo.service;

import com.example.demo.model.ShiftTemplate;
import java.util.List;

public interface ShiftTemplateService {
    ShiftTemplate create(ShiftTemplate shiftTemplate);
    ShiftTemplate get(Long id);
    ShiftTemplate update(Long id, ShiftTemplate shiftTemplate);
    void delete(Long id);
    List<ShiftTemplate> getAll();
    List<ShiftTemplate> getByDepartment(Long departmentId);
}