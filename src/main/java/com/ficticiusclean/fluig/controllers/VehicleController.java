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
    public ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(service.getAllVehicles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(service.create(vehicle), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(service.update(vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
