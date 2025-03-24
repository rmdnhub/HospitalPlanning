package com.example.HopitalPlanningProject.controllers;

import com.example.HopitalPlanningProject.model.Roulement;
import com.example.HopitalPlanningProject.services.RoulementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/roulements")
public class RoulementController {

    private final RoulementService roulementService;

    public RoulementController(RoulementService roulementService) {
        this.roulementService = roulementService;
    }

    @GetMapping
    public List<Roulement> getAllRoulements() {
        return roulementService.getAllRoulements();
    }

    @GetMapping("/{id}")
    public Optional<Roulement> getRoulementById(@PathVariable int id) {
        return roulementService.getRoulementById(id);
    }

    // @PostMapping
    // public Roulement createRoulement(@RequestBody Roulement roulement) {
    //     // return roulementService.createRoulement(roulement);
    //     //  methode n existe pas dans le service aussi
    // }

    @DeleteMapping("/{id}")
    public void deleteRoulement(@PathVariable int id) {
        roulementService.deleteRoulement(id);
    }
}

