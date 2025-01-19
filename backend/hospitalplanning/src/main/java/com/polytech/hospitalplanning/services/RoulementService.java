package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Roulement;
import com.polytech.hospitalplanning.repositories.RoulementRepository;

@Service
public class RoulementService {
    private final RoulementRepository repository;

    public RoulementService(RoulementRepository repository) {
        this.repository = repository;
    }

    public List<Roulement> findAll() {
        return repository.findAll();
    }

    public Roulement save(Roulement roulement) {
        return repository.save(roulement);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
