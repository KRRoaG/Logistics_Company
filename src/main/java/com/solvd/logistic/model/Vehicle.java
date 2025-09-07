package com.solvd.logistic.model;

public abstract class Vehicle {

    private String type;
    private String plateNumber;


    public Vehicle(String type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

    // Getters
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String getInfo();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle other = (Vehicle) obj;
        return this.getPlateNumber().equals(other.getPlateNumber());
    }

    @Override
    public int hashCode() {
        return this.getPlateNumber().hashCode();
    }

}
