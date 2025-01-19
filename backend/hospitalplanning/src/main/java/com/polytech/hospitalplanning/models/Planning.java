package com.polytech.hospitalplanning.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Roulement> roulements;

    @OneToMany
    private List<Besoin> besoins;

    @ElementCollection
    private List<String> contraintes;

    public boolean isContrainteMet(String contrainte) {
        return contraintes.contains(contrainte);
    }
}