package com.FishPond.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.FishPond.Entity.Pond;
import com.FishPond.Entity.Sensor;
import com.FishPond.Repository.PondRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/ponds")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as per your frontend URL
public class PondController {

    @Autowired
    private PondRepository pondRepository;

    // Get all ponds
    @GetMapping
    public List<Pond> getAllPonds() {
        return pondRepository.findAll();
    }

    // Add a new pond
    @PostMapping
    public Pond addPond(@RequestBody Pond pond) {
        return pondRepository.save(pond);
    }

    // Get sensors for a specific pond
    @GetMapping("/{pondId}/sensors")
    public List<Sensor> getSensorsByPond(@PathVariable String pondId) {
        Pond pond = pondRepository.findById(pondId)
                .orElseThrow(() -> new RuntimeException("Pond not found with ID: " + pondId));
        return pond.getSensors();
    }

    // Add a sensor to a specific pond
    @PostMapping("/{pondId}/sensors")
    public Pond addSensorToPond(@PathVariable String pondId, @RequestBody Sensor sensor) {
        Pond pond = pondRepository.findById(pondId)
                .orElseThrow(() -> new RuntimeException("Pond not found with ID: " + pondId));
        pond.addSensor(sensor);
        return pondRepository.save(pond);
    }

    // Optional: Get a specific pond by ID
    @GetMapping("/{pondId}")
    public Optional<Pond> getPondById(@PathVariable String pondId) {
        return pondRepository.findById(pondId);
    }
}
