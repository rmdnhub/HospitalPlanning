package com.example.HopitalPlanningProject.controllers;

import com.example.HopitalPlanningProject.model.InterdictionPrecedent;
import com.example.HopitalPlanningProject.model.InterdictionPrecedentId;
import com.example.HopitalPlanningProject.services.InterdictionPrecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/interdictionsPrecedents")
public class InterdictionPrecedentController {

    @Autowired
    private InterdictionPrecedentService interdictionPrecedentService;

    @GetMapping
    public List<InterdictionPrecedent> getAllInterdictions() {
        return interdictionPrecedentService.getAllInterdictions();
    }

    @PostMapping
    public InterdictionPrecedent createInterdiction(@RequestBody Map<String, Integer> payload) {
        Integer idShift = payload.get("idShift");
        Integer idShift1 = payload.get("idShift1");
        if (idShift == null || idShift1 == null) {
            throw new IllegalArgumentException("Both idShift and idShift1 must be provided");
        }
        InterdictionPrecedentId key = new InterdictionPrecedentId(idShift, idShift1);
        InterdictionPrecedent interdiction = new InterdictionPrecedent();
        interdiction.setId(key);
        return interdictionPrecedentService.createInterdiction(interdiction);
    }

    // @DeleteMapping
    // public ResponseEntity<Void> deleteInterdiction(@RequestParam("first") int
    // idShift,
    // @RequestParam("second") int idShift1) {
    // interdictionPrecedentService.deleteInterdiction(idShift, idShift1);
    // return ResponseEntity.noContent().build();
    // }

    @DeleteMapping
    public ResponseEntity<Void> deleteInterdiction(@RequestParam("first") int idShift,
            @RequestParam("second") int idShift1) {
        interdictionPrecedentService.deleteInterdiction(idShift, idShift1);
        return ResponseEntity.noContent().build();
    }

}
