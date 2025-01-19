package com.polytech.hospitalplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.hospitalplanning.models.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
}
