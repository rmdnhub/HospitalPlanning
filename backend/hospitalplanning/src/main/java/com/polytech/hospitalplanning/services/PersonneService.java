package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Personne;
import com.polytech.hospitalplanning.repositories.PersonneRepository;

@Service
public class PersonneService {
    private final PersonneRepository repository;

    public PersonneService(PersonneRepository repository) {
        this.repository = repository;
    }

    public List<Personne> findAll() {
        return repository.findAll();
    }

    public Personne save(Personne personne) {
        return repository.save(personne);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}