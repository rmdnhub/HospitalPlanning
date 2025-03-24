package com.example.HopitalPlanningProject.repositories;

import com.example.HopitalPlanningProject.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {
}

