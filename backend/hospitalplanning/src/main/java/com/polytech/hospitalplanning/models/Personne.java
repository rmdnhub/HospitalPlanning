package com.polytech.hospitalplanning.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private Integer typeContrat;
    private Integer dureeMax;
    private Integer dureeMin;
    private Integer joursOffMin;
    private Integer weekendsMax;

    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
    private List<Shift> shiftsAssignes;

    @ElementCollection
    private List<Integer> joursConges;


    public void ajouterJourConge(int jour) {
        if (!joursConges.contains(jour)) {
            joursConges.add(jour);
        }
    }

    public void assignerShift(Shift shift) {
        if (shift != null && !shiftsAssignes.contains(shift)) {
            shiftsAssignes.add(shift);
        }
    }

    public int calculerChargeTravail() {
        return shiftsAssignes.stream().mapToInt(Shift::getDuree).sum();
    }

    public boolean verifierCompatibiliteContrat() {
        int totalDuree = calculerChargeTravail();
        return totalDuree >= dureeMin && totalDuree <= dureeMax;
    }

    public boolean isAvailable(Integer jour) {
        return !joursConges.contains(jour);
    }

    public boolean exceedsMaxDuree(Integer duree) {
        return duree > dureeMax;
    }

    public boolean respectsMinDuree(Integer duree) {
        return duree >= dureeMin;
    }
}
