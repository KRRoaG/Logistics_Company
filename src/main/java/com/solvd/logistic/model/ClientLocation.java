package com.solvd.logistic.model;

public class ClientLocation extends Location {

    public ClientLocation(String city, String address, String postalCode)
    {
        super(city, address, postalCode);
    }

    @Override
    public String getLocationType() {
        return "Client";
    }
}