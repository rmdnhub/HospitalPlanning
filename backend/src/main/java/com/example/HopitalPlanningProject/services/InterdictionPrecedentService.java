package com.example.HopitalPlanningProject.services;

import com.example.HopitalPlanningProject.model.InterdictionPrecedent;
import com.example.HopitalPlanningProject.model.InterdictionPrecedentId;
import com.example.HopitalPlanningProject.repositories.InterdictionPrecedentRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterdictionPrecedentService {

    @Autowired
    private InterdictionPrecedentRepository interdictionPrecedentRepository;

    public List<InterdictionPrecedent> getAllInterdictions() {
        return interdictionPrecedentRepository.findAll();
    }

    public Optional<InterdictionPrecedent> getInterdictionById(int id) {
        return interdictionPrecedentRepository.findById(id);
    }

    public InterdictionPrecedent createInterdiction(InterdictionPrecedent interdictionPrecedent) {
        return interdictionPrecedentRepository.save(interdictionPrecedent);
    }

    public void deleteInterdiction(int id) {
        interdictionPrecedentRepository.deleteById(id);
    }

    public void deleteInterdiction(int idShift, int idShift1) {
        InterdictionPrecedentId key = new InterdictionPrecedentId(idShift, idShift1);
        Optional<InterdictionPrecedent> interdiction = interdictionPrecedentRepository.findById(key.getIdShift());

        if (interdiction.isPresent() && interdiction.get().getId().getIdShift1() == idShift1) {
            interdictionPrecedentRepository.delete(interdiction.get());
        } else {
            throw new EntityNotFoundException("Interdiction not found for shifts: " + idShift + " and " + idShift1);
        }
    }

}
