package com.traffic.system.controller;

import com.traffic.system.entity.Violation;
import com.traffic.system.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrafficViewController {

    @Autowired
    private ViolationRepository repo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("violations", repo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addViolation(@RequestParam String vehicleId,
                               @RequestParam double speed,
                               @RequestParam String zone) {

        Violation v = new Violation();
        v.setVehicleId(vehicleId);
        v.setSpeed(speed);
        v.setZone(zone);

        int fine = 0;
        if (speed > 120) fine = 5000;
        else if (speed > 100) fine = 2000;
        else if (speed > 80) fine = 1000;

        v.setFine(fine);
        repo.save(v);

        return "redirect:/";
    }
}