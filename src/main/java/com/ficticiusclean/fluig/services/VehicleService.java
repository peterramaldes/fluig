package com.ficticiusclean.fluig.services;

import com.ficticiusclean.fluig.models.Vehicle;
import com.ficticiusclean.fluig.models.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private IVehicleRepository repository;

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Transactional
    public Vehicle createOrUpdateVehicle(Vehicle vehicle) {
        Optional<Vehicle> oVehicle = vehicle.getId() != null
                ? repository.findById(vehicle.getId())
                : Optional.of(vehicle);

        if (oVehicle.isPresent()) {
            Vehicle nVehicle = oVehicle.get();
            nVehicle.setName(vehicle.getName());
            nVehicle.setBrand(vehicle.getBrand());
            nVehicle.setModel(vehicle.getModel());
            nVehicle.setFabrication(vehicle.getFabrication());
            nVehicle.setAvarageCity(vehicle.getAvarageCity());
            nVehicle.setAvarageHighway(vehicle.getAvarageHighway());

            return repository.save(nVehicle);
        } else {
            return repository.save(vehicle);
        }
    }

}
