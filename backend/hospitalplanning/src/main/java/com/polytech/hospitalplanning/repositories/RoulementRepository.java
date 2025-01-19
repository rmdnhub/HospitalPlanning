package com.polytech.hospitalplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.hospitalplanning.models.Roulement;

public interface RoulementRepository extends JpaRepository<Roulement, Integer> {
}
