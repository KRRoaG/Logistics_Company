package com.solvd.logistic.model;

import com.solvd.logistic.enums.Gender;
import com.solvd.logistic.exceptions.InvalidAddressException;

public class Client extends Person {

    private String address;

    public Client(String name, String address, String id, Gender gender) {
        super(name,id, gender);
        this.address = address;
    }

    //Getters & Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws InvalidAddressException {
        if (address == null || address.trim().isEmpty()) {
            throw new InvalidAddressException("Address it's empty");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client: " + getInfo() + ", Address: " + address ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        return this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
