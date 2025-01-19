package com.polytech.hospitalplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.hospitalplanning.models.Besoin;

public interface BesoinRepository extends JpaRepository<Besoin, Integer> {
}
