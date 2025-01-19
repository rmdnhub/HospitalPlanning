package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Shift;
import com.polytech.hospitalplanning.repositories.ShiftRepository;

@Service
public class ShiftService {
    private final ShiftRepository repository;

    public ShiftService(ShiftRepository repository) {
        this.repository = repository;
    }

    public List<Shift> findAll() {
        return repository.findAll();
    }

    public Shift save(Shift shift) {
        return repository.save(shift);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}