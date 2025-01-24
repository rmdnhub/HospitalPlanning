package com.polytech.hospitalplanning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Roulement;
import com.polytech.hospitalplanning.repositories.RoulementRepository;
import com.polytech.hospitalplanning.models.Shift;

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

    public void genererRoulement(Roulement roulement) {
        List<Shift> shifts = roulement.getShifts();
        if (shifts.isEmpty()) {
            throw new IllegalStateException("Impossible de générer un roulement : la liste des shifts est vide.");
        }

        // Exemple de logique pour générer un roulement
        for (Shift shift : shifts) {
            System.out.println("Shift généré : " + shift); // Remplacer par la logique de Kergosien
        }
    }
}
