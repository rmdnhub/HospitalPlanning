package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Besoin;
import com.polytech.hospitalplanning.repositories.BesoinRepository;

@Service
public class BesoinService {
    private final BesoinRepository repository;

    public BesoinService(BesoinRepository repository) {
        this.repository = repository;
    }

    public List<Besoin> findAll() {
        return repository.findAll();
    }

    public Besoin save(Besoin besoin) {
        return repository.save(besoin);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

