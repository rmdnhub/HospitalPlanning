package com.polytech.hospitalplanning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.hospitalplanning.models.Personne;
import com.polytech.hospitalplanning.services.PersonneService;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
    private final PersonneService service;

    public PersonneController(PersonneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return service.findAll();
    }

    @PostMapping
    public Personne createPersonne(@RequestBody Personne personne) {
        return service.save(personne);
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
