package com.traffic.system.controller;

import com.traffic.system.entity.Violation;
import com.traffic.system.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    private ViolationRepository repo;

    @PostMapping("/check")
    public Violation checkViolation(@RequestBody Violation v) {

        int fine = 0;

        if (v.getSpeed() > 120) fine = 5000;
        else if (v.getSpeed() > 100) fine = 2000;
        else if (v.getSpeed() > 80) fine = 1000;

        v.setFine(fine);

        return repo.save(v);
    }

    @GetMapping("/all")
    public List<Violation> getAll() {
        return repo.findAll();
    }
}