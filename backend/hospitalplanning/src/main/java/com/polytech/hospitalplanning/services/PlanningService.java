package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Planning;
import com.polytech.hospitalplanning.repositories.PlanningRepository;

@Service
public class PlanningService {
    private final PlanningRepository repository;

    public PlanningService(PlanningRepository repository) {
        this.repository = repository;
    }

    public List<Planning> findAll() {
        return repository.findAll();
    }

    public Planning save(Planning planning) {
        return repository.save(planning);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public boolean validateContrainte(String contrainte) {
        return findAll().stream().anyMatch(p -> p.isContrainteMet(contrainte));
    }
}