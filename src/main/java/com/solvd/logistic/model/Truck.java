package com.solvd.logistic.model;

public class Truck extends Vehicle{

    private double capacityLb;
    private boolean availability;

    public Truck(String type, String plateNumber, double capacityKg, boolean availability) {
        super(type,plateNumber);
        this.capacityLb = capacityKg;
        this.availability = availability;
    }

    // Getters
    public double getCapacityKg() {
        return capacityLb;
    }

    public boolean checkAvailability() {
        return availability;
    }

    // Setters
    public void setCapacityKg(double capacityKg) {
        this.capacityLb = capacityKg;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String getInfo() {
        return "Vehicle { Plate: " + getPlateNumber()
                + ", Capacity (lb): " + capacityLb + ", Available?: " + availability + " }";
    }
}
