package com.solvd.logistic.model;

import com.solvd.logistic.enums.Zone;

public record DistributionCenter (String name, String city, String address, Zone zone){

    @Override
    public String toString() {
        return "DistributionCenter {Name: " + name +
                ", City: " + city +
                ", Address: " + address + "}";
    }
}
