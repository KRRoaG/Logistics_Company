package com.solvd.logistic.tracking;

public class SimpleLocationProvider implements ILocationProvider{
    private final String[] locations = {"Bogota", "Medellin" , "Bucaramanga", "Barranquilla", "Cartagena"};
    private int index= 0;

    @Override
    public String getCurrentLocation() {
        if (index < locations.length - 1){
            index++;
            return locations[index];
        }else {
            return "Final Destination";
        }
    }

    @Override
    public boolean hasMoreLocations() {
        return index < locations.length - 1 ;
    }
}
