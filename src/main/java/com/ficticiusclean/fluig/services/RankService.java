package com.ficticiusclean.fluig.services;

import com.ficticiusclean.fluig.controllers.dtos.VehicleDTO;
import com.ficticiusclean.fluig.models.Vehicle;
import com.ficticiusclean.fluig.models.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RankService {

    @Autowired
    private IVehicleRepository repository;

    @Transactional
    public List<VehicleDTO> rank(BigDecimal price, Double totalCity, Double totalHighway) {
        List<Vehicle> entities = repository.findAll();
        List<VehicleDTO> dtos = new ArrayList<>();

        entities.forEach(v -> dtos.add(calc(v, price, totalCity, totalHighway)));
        Collections.sort(dtos);

        return dtos;
    }

    private VehicleDTO calc(Vehicle v, BigDecimal price, Double totalCity, Double totalHighway) {
        double fuelSpend = (totalCity / v.getAvarageCity()) + (totalHighway / v.getAvarageHighway());
        BigDecimal moneySpend = price.multiply(new BigDecimal(fuelSpend));

        return mapEntityToDTO(v, fuelSpend, moneySpend);
    }

    private VehicleDTO mapEntityToDTO(Vehicle i, Double fueldSpend, BigDecimal moneySpend) {
        VehicleDTO o = new VehicleDTO();

        o.setName(i.getName());
        o.setBrand(i.getBrand());
        o.setFabrication(i.getFabrication());
        o.setModel(i.getModel());
        o.setFuelSpend(fueldSpend);
        o.setMoneySpend(round(moneySpend, 2, true));

        return o;
    }

    private BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
        int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
        return d.setScale(scale, mode);
    }
}
