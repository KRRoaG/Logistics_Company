package com.solvd.logistic.model;

public class StandartPackage extends PackageBase {

    private String shipNumber;

    public StandartPackage(String shipNumber, Double weight, String description) {
        super(weight, description);
        this.shipNumber = shipNumber;
    }

    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
    }

    @Override
    public double calculateShippingCost() {
        return getWeight() * 2.0; // example base cost
    }

    @Override
    public String toString() {
        return "Package { Ship Number: " + shipNumber +
                ", Weight [lb]: " + getWeight() +
                ", Description: " + getDescription() +
                ", Shipping Cost: $" + calculateShippingCost() +
                " }";
    }
}
