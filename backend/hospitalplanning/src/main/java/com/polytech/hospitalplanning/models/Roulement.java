package com.polytech.hospitalplanning.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Roulement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Personne> personnes;

    @ManyToMany
    private List<Shift> shifts;

    public boolean isValidRotation() {
        return personnes.size() == shifts.size();
    }

    public void addPersonneToShift(Personne personne, Shift shift) {
        personnes.add(personne);
        shifts.add(shift);
    }
}