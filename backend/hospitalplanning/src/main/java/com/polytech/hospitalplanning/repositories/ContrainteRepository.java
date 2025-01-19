package com.polytech.hospitalplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.hospitalplanning.models.Contrainte;

public interface ContrainteRepository extends JpaRepository<Contrainte, Integer> {
}
