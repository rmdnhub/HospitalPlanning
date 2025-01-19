package com.polytech.hospitalplanning.models;

import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Besoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private Map<String, Integer> besoinParJour;

    public boolean isFulfilled(String jour, Integer available) {
        return available >= besoinParJour.getOrDefault(jour, 0);
    }
}