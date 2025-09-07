package com.solvd.logistic.service;

public class PriceCalculator {

    private static final double WEIGHT_FEE = 2;
    private static final double DISTANCE_FEE = 0.1;

    private PriceCalculator() {
        /*
        Doesn't have constructor
         It only has static methods
         */
    }

    public static double computePrice(double weight, double distance) {
        return (weight * WEIGHT_FEE) + (distance * DISTANCE_FEE);
    }

    public static double computePrice(double weight, double distance, double discount) {
        double normalPrice = computePrice(weight, distance);
        return normalPrice - (normalPrice * discount);
    }
}
