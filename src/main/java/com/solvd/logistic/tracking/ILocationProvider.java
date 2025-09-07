package com.solvd.logistic.tracking;

public interface ILocationProvider {
    String getCurrentLocation();
    boolean hasMoreLocations();
}
