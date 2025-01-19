package com.polytech.hospitalplanning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.hospitalplanning.models.Besoin;
import com.polytech.hospitalplanning.services.BesoinService;

@RestController
@RequestMapping("/api/besoins")
public class BesoinController {
    private final BesoinService service;

    public BesoinController(BesoinService service) {
        this.service = service;
    }

    @GetMapping
    public List<Besoin> getAllBesoins() {
        return service.findAll();
    }

    @PostMapping
    public Besoin createBesoin(@RequestBody Besoin besoin) {
        return service.save(besoin);
    }

    @DeleteMapping("/{id}")
    public void deleteBesoin(@PathVariable Integer id) {
        service.deleteById(id);
    }
}

