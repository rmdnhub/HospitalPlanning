package com.polytech.hospitalplanning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.hospitalplanning.models.Roulement;
import com.polytech.hospitalplanning.services.RoulementService;

@RestController
@RequestMapping("/api/roulements")
public class RoulementController {
    private final RoulementService service;

    public RoulementController(RoulementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Roulement> getAllRoulements() {
        return service.findAll();
    }

    @PostMapping
    public Roulement createRoulement(@RequestBody Roulement roulement) {
        return service.save(roulement);
    }

    @DeleteMapping("/{id}")
    public void deleteRoulement(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
