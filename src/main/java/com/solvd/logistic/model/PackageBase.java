package com.solvd.logistic.model;

import com.solvd.logistic.exceptions.InvalidWeightException;

public abstract class PackageBase {
    protected String shipNumber;
    protected double weight;
    protected String description;

    public PackageBase(double weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public String getShipNumber() {
        return shipNumber;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void setWeight (double weight) throws InvalidWeightException {
        if(weight<0){
            throw new InvalidWeightException("Weight must be positive");
        }
        if (weight>200){
            throw new InvalidWeightException("This package exceeds the weight limit");
        }
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateShippingCost();

    @Override
    public String toString() {
        return "Package [Description: " + description + ", Weight: " + weight + " kg]";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj ==null || getClass() != obj.getClass()) return false;
        PackageBase other = (PackageBase) obj;
        return this.getShipNumber().equals(other.getShipNumber());
    }

    @Override
    public int hashCode(){
        return this.getShipNumber().hashCode();
    }

}
