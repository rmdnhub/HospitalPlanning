package com.polytech.hospitalplanning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.hospitalplanning.models.Contrainte;
import com.polytech.hospitalplanning.services.ContrainteService;

@RestController
@RequestMapping("/api/contraintes")
public class ContrainteController {
    private final ContrainteService service;

    public ContrainteController(ContrainteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contrainte> getAllContraintes() {
        return service.findAll();
    }

    @PostMapping
    public Contrainte createContrainte(@RequestBody Contrainte contrainte) {
        return service.save(contrainte);
    }

    @DeleteMapping("/{id}")
    public void deleteContrainte(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
