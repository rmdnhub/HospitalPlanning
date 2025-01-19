package com.polytech.hospitalplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.hospitalplanning.models.Planning;

public interface PlanningRepository extends JpaRepository<Planning, Integer> {
}