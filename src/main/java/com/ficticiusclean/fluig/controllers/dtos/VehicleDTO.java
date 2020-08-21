package com.ficticiusclean.fluig.controllers.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class VehicleDTO implements Serializable, Comparable<VehicleDTO> {
    private static final long serialVersionUID = -5471683187877880343L;

    private String name;
    private String brand;
    private String model;
    private String fabrication;
    private Double fuelSpend;
    private BigDecimal moneySpend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFabrication() {
        return fabrication;
    }

    public void setFabrication(String fabrication) {
        this.fabrication = fabrication;
    }

    public Double getFuelSpend() {
        return fuelSpend;
    }

    public void setFuelSpend(Double fuelSpend) {
        this.fuelSpend = fuelSpend;
    }

    public BigDecimal getMoneySpend() {
        return moneySpend;
    }

    public void setMoneySpend(BigDecimal moneySpend) {
        this.moneySpend = moneySpend;
    }

    @Override
    public int compareTo(VehicleDTO o) {
        return o.moneySpend.compareTo(this.moneySpend);
    }
}
