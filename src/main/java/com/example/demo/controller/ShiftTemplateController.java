package com.example.demo.controller;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.ShiftTemplateService;
import java.util.List;

public class ShiftTemplateController {
    private final ShiftTemplateService shiftTemplateService;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService, 
                                  DepartmentRepository departmentRepository) {
        this.shiftTemplateService = shiftTemplateService;
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<List<ShiftTemplate>> list() {
        return new ResponseEntity<>(shiftTemplateService.getAll());
    }

    public ResponseEntity<ShiftTemplate> get(Long id) {
        return new ResponseEntity<>(shiftTemplateService.get(id));
    }

    public ResponseEntity<ShiftTemplate> create(ShiftTemplate shiftTemplate) {
        return new ResponseEntity<>(shiftTemplateService.create(shiftTemplate));
    }

    public ResponseEntity<ShiftTemplate> update(Long id, ShiftTemplate shiftTemplate) {
        return new ResponseEntity<>(shiftTemplateService.update(id, shiftTemplate));
    }

    public ResponseEntity<String> delete(Long id) {
        shiftTemplateService.delete(id);
        return new ResponseEntity<>("Deleted");
    }

    public static class ResponseEntity<T> {
        private final T body;
        public ResponseEntity(T body) { this.body = body; }
        public T getBody() { return body; }
    }
}