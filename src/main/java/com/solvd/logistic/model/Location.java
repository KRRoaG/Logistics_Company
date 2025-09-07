package com.solvd.logistic.model;

public abstract class Location {
    private String city;
    private String address;
    private String postalCode;

    public Location(String city, String address, String postalCode) {
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public abstract String getLocationType();

    @Override
    public String toString() {
        return getLocationType() + " Location: " + address + ", " + city + ", " + postalCode;
    }
}
