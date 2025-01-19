package com.polytech.hospitalplanning.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private Integer duree;
    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;
    @ManyToMany
    private List<Shift> shiftsInterdits;

    public boolean isCompatibleWith(Shift otherShift) {
        return !shiftsInterdits.contains(otherShift);
    }

    public void ajouterShiftInterdit(Shift shift) {
        if (!shiftsInterdits.contains(shift)) {
            shiftsInterdits.add(shift);
        }
    }

    public String getDetails() {
        return "Shift [ID=" + id + ", Type=" + type + ", Durée=" + duree + " heures]";
    }
}
