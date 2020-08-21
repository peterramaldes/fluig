package com.ficticiusclean.fluig.controllers;

import com.ficticiusclean.fluig.models.Vehicle;
import com.ficticiusclean.fluig.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(service.getAllVehicles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createOrUpdateVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(service.createOrUpdateVehicle(vehicle), HttpStatus.OK);
    }
}
