package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Contrainte;
import com.polytech.hospitalplanning.repositories.ContrainteRepository;

@Service
public class ContrainteService {
    private final ContrainteRepository repository;

    public ContrainteService(ContrainteRepository repository) {
        this.repository = repository;
    }

    public List<Contrainte> findAll() {
        return repository.findAll();
    }

    public Contrainte save(Contrainte contrainte) {
        return repository.save(contrainte);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}