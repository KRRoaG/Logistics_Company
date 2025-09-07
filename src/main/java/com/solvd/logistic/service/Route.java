package com.solvd.logistic.service;

import com.solvd.logistic.exceptions.RouteNotFoundException;

public class Route {

    private String origin;
    private String destination;
    private double distance;
    private String code;

    public Route(String origin, String destination, double distance, String code) throws RouteNotFoundException {
        if (origin == null || origin.trim().isEmpty() ||
                destination == null || destination.trim().isEmpty() ||
                distance <= 0) {
            throw new RouteNotFoundException("Could not find a valid route");
        }
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.code = code;
    }

    // Getters
    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public String getCode() {
        return code;
    }

    // Setters
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        if (distance <= 0){
            throw new IllegalArgumentException("Distance cannot be negative.");
        }
        this.distance = distance;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return " Route { Code: " + code +
                ", Origen: " + origin +
                ", Destination: " + destination +
                ", Distance (km): " + distance + " }";
    }
}
