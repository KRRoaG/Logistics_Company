package com.solvd.logistic.model;

import com.solvd.logistic.enums.Gender;

public class Employee extends Person {
    private String rol;
    private String zone;
    private boolean active;

    public Employee(String name, String id, Gender gender, String rol, String zone, boolean active) {
        super(name,id, gender);
        this.rol = rol;
        this.zone = zone;
        this.active = active;
    }

    // Getters
    public String getRol() {
        return rol;
    }

    public String getZone() {
        return zone;
    }

    public boolean isActive() {
        return active;
    }

    // Setters
    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return " Employee { Name: " + getInfo() +
                ", Rol: " + rol +
                ", Zone assigned: " + zone +
                ", Active?: " + active + " }";
    }
}
