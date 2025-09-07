package com.solvd.logistic.model;

import com.solvd.logistic.enums.Zone;

public class DistributionCenter {
    private String name;
    private String city;
    private String address;
    private final Zone zone;

    // Custom constructor
    public DistributionCenter(String name, String city, String address, Zone zone) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.zone = zone;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Zone getZone() {return zone;}

    public String getAddress() {
        return address;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "DistributionCenter {Name: " + name +
                ", City: " + city +
                ", Address: " + address + "}";
    }
}
