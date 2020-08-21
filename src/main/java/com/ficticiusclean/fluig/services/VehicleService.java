package com.ficticiusclean.fluig.services;

import com.ficticiusclean.fluig.models.Vehicle;
import com.ficticiusclean.fluig.models.repositories.IVehicleRepository;
import com.ficticiusclean.fluig.utils.BusinessException;
import com.ficticiusclean.fluig.utils.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private IVehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        // TODO: fields validation
        return repository.save(vehicle);
    }

    @Transactional
    public Vehicle update(Vehicle vehicle) {
        // TODO: fields validation
        Optional.ofNullable(vehicle.getId()).orElseThrow(() -> new BusinessException("Id cannot be null."));

        Vehicle v = repository.findById(vehicle.getId()).orElseThrow(
                () -> new RecordNotFoundException("Vehicle id '" + vehicle.getId() + "' does no exist")
        );

        v.setName(vehicle.getName());
        v.setBrand(vehicle.getBrand());
        v.setModel(vehicle.getModel());
        v.setFabrication(vehicle.getFabrication());
        v.setAvarageCity(vehicle.getAvarageCity());
        v.setAvarageHighway(vehicle.getAvarageHighway());

        return repository.save(v);
    }

    @Transactional
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Vehicle id '" + id + "' does no exist"));
        repository.deleteById(id);
    }

}
