package com.example.demo.service.impl;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    private final ShiftTemplateRepository shiftTemplateRepository;

    public ShiftTemplateServiceImpl(ShiftTemplateRepository shiftTemplateRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
    }

    @Override
    public ShiftTemplate create(ShiftTemplate template) {
        if (template.getEndTime().isBefore(template.getStartTime())) {
            throw new RuntimeException("Invalid time");
        }

        shiftTemplateRepository
                .findByTemplateNameAndDepartment_Id(
                        template.getTemplateName(),
                        template.getDepartment().getId()
                )
                .ifPresent(t -> {
                    throw new RuntimeException("Template already exists");
                });

        return shiftTemplateRepository.save(template);
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return shiftTemplateRepository.findByDepartment_Id(departmentId);
    }
}
