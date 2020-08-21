package com.ficticiusclean.fluig.models;

import javax.persistence.*;

@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String fabrication;

    @Column
    private Double avarageCity;

    @Column
    private Double avarageHighway;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getAvarageCity() {
        return avarageCity;
    }

    public void setAvarageCity(Double avarageCity) {
        this.avarageCity = avarageCity;
    }

    public Double getAvarageHighway() {
        return avarageHighway;
    }

    public void setAvarageHighway(Double avarageHighway) {
        this.avarageHighway = avarageHighway;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fabrication=" + fabrication +
                ", avarageCity=" + avarageCity +
                ", avarageHighway=" + avarageHighway +
                '}';
    }
}
