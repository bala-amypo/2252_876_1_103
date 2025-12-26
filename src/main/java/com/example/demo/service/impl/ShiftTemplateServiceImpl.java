package com.example.demo.service.impl;

import com.example.demo.model.Department;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import java.util.List;

public class ShiftTemplateServiceImpl implements ShiftTemplateService {
    private final ShiftTemplateRepository shiftTemplateRepository;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository shiftTemplateRepository, 
                                   DepartmentRepository departmentRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ShiftTemplate create(ShiftTemplate shiftTemplate) {
        Department department = departmentRepository.findById(shiftTemplate.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        
        if (shiftTemplate.getEndTime().isBefore(shiftTemplate.getStartTime()) || 
            shiftTemplate.getEndTime().equals(shiftTemplate.getStartTime())) {
            throw new RuntimeException("End time must be after start time");
        }
        
        if (shiftTemplateRepository.findByTemplateNameAndDepartment_Id(
                shiftTemplate.getTemplateName(), department.getId()).isPresent()) {
            throw new RuntimeException("Shift template name must be unique within department");
        }
        
        return shiftTemplateRepository.save(shiftTemplate);
    }

    @Override
    public ShiftTemplate get(Long id) {
        return shiftTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift template not found"));
    }

    @Override
    public ShiftTemplate update(Long id, ShiftTemplate shiftTemplate) {
        ShiftTemplate existing = shiftTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift template not found"));
        
        existing.setTemplateName(shiftTemplate.getTemplateName());
        existing.setStartTime(shiftTemplate.getStartTime());
        existing.setEndTime(shiftTemplate.getEndTime());
        existing.setRequiredSkills(shiftTemplate.getRequiredSkills());
        
        return shiftTemplateRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        ShiftTemplate shiftTemplate = shiftTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift template not found"));
        shiftTemplateRepository.delete(shiftTemplate);
    }

    @Override
    public List<ShiftTemplate> getAll() {
        return shiftTemplateRepository.findAll();
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return shiftTemplateRepository.findByDepartment_Id(departmentId);
    }
}