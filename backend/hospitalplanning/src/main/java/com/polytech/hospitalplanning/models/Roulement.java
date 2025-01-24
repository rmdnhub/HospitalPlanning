package com.polytech.hospitalplanning.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Roulement {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Shift> shifts = new ArrayList<>();

    // Méthodes

    public List<Shift> getShifts() {
        return new ArrayList<>(shifts);
    }

    public void ajouterShift(Shift shift) {
        shifts.add(shift);
    }

    public void genererRoulement() {
    }
}