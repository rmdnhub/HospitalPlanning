package com.polytech.hospitalplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.hospitalplanning.models.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}