package com.traffic.system.controller;

import com.traffic.system.entity.Violation;
import com.traffic.system.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TrafficViewController {

    @Autowired
    private ViolationRepository repo;

    @GetMapping("/")
    public String home(Model model) {

        List<Violation> list = repo.findAll();

        int totalViolations = list.size();
        int totalFine = list.stream().mapToInt(Violation::getFine).sum();
        double maxSpeed = list.stream()
                .mapToDouble(Violation::getSpeed)
                .max()
                .orElse(0);

        model.addAttribute("violations", list);
        model.addAttribute("totalViolations", totalViolations);
        model.addAttribute("totalFine", totalFine);
        model.addAttribute("maxSpeed", maxSpeed);

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