package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Shift Template Endpoints")
public class ShiftTemplateController {

    @PostMapping("/department/{departmentId}")
    public String createTemplate(@PathVariable Long departmentId) {
        return "Shift Template Created";
    }

    @GetMapping("/department/{departmentId}")
    public String getTemplates(@PathVariable Long departmentId) {
        return "Templates for Department " + departmentId;
    }
}
