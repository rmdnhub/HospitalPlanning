package com.polytech.hospitalplanning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.hospitalplanning.models.Planning;
import com.polytech.hospitalplanning.services.PlanningService;

@RestController
@RequestMapping("/api/plannings")
public class PlanningController {
    private final PlanningService service;

    public PlanningController(PlanningService service) {
        this.service = service;
    }

    @GetMapping
    public List<Planning> getAllPlannings() {
        return service.findAll();
    }

    @PostMapping
    public Planning createPlanning(@RequestBody Planning planning) {
        return service.save(planning);
    }

    @DeleteMapping("/{id}")
    public void deletePlanning(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/validate")
    public boolean validateContrainte(@RequestParam String contrainte) {
        return service.validateContrainte(contrainte);
    }
}
