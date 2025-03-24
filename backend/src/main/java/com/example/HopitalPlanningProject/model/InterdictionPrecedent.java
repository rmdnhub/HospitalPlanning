package com.example.HopitalPlanningProject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class InterdictionPrecedent {
    @EmbeddedId
    private InterdictionPrecedentId id;

    public InterdictionPrecedent() {
    }
    
    public InterdictionPrecedent(InterdictionPrecedentId id) {
        this.id = id;
    }
    // Getters, setters et autres méthodes

    public InterdictionPrecedentId getId() {
        return id;
    }

    public void setId(InterdictionPrecedentId id) {
        this.id = id;
    }
}

