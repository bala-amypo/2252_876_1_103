package com.example.demo.repository;

import com.example.demo.model.ShiftTemplate;
import java.util.List;
import java.util.Optional;

public interface ShiftTemplateRepository {
    ShiftTemplate save(ShiftTemplate shiftTemplate);
    Optional<ShiftTemplate> findById(Long id);
    List<ShiftTemplate> findAll();
    void delete(ShiftTemplate shiftTemplate);
    Optional<ShiftTemplate> findByTemplateNameAndDepartment_Id(String templateName, Long departmentId);
    List<ShiftTemplate> findByDepartment_Id(Long departmentId);
}