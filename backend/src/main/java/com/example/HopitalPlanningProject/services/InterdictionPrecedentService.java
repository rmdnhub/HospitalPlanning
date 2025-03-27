package com.example.HopitalPlanningProject.services;

import com.example.HopitalPlanningProject.model.InterdictionPrecedent;
import com.example.HopitalPlanningProject.model.InterdictionPrecedentId;
import com.example.HopitalPlanningProject.repositories.InterdictionPrecedentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class InterdictionPrecedentService {

    @Autowired
    private InterdictionPrecedentRepository interdictionPrecedentRepository;

    @PersistenceContext
    private EntityManager entityManager;
    
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

    // public void deleteInterdiction(int idShift, int idShift1) {
    //     InterdictionPrecedentId key = new InterdictionPrecedentId(idShift, idShift1);
    //     Optional<InterdictionPrecedent> interdiction = interdictionPrecedentRepository.findById(key.getIdShift());

    //     if (interdiction.isPresent() && interdiction.get().getId().getIdShift1() == idShift1) {
    //         interdictionPrecedentRepository.delete(interdiction.get());
    //     } else {
    //         throw new EntityNotFoundException("Interdiction not found for shifts: " + idShift + " and " + idShift1);
    //     }
    // }

    @Transactional
    public void deleteInterdiction(int idShift, int idShift1) {
        // Use a JPQL delete query to remove the interdiction with the given composite key values.
        entityManager.createQuery("DELETE FROM InterdictionPrecedent ip WHERE ip.id.idShift = :idShift AND ip.id.idShift1 = :idShift1")
            .setParameter("idShift", idShift)
            .setParameter("idShift1", idShift1)
            .executeUpdate();
    }

}
