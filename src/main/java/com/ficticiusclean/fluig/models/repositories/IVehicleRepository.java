package com.ficticiusclean.fluig.models.repositories;

import com.ficticiusclean.fluig.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository
        extends JpaRepository<Vehicle, Long> {
}
