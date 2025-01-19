package com.polytech.hospitalplanning.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.hospitalplanning.models.Shift;
import com.polytech.hospitalplanning.services.ShiftService;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {
    private final ShiftService service;

    public ShiftController(ShiftService service) {
        this.service = service;
    }

    @GetMapping
    public List<Shift> getAllShifts() {
        return service.findAll();
    }

    @PostMapping
    public Shift createShift(@RequestBody Shift shift) {
        return service.save(shift);
    }

    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable Integer id) {
        service.deleteById(id);
    }
}

