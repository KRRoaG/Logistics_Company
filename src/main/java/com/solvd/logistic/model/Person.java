package com.solvd.logistic.model;

import com.solvd.logistic.enums.Gender;
import com.solvd.logistic.exceptions.InvalidIDException;

public abstract class Person {

    private String name;
    private String id;
    private final Gender gender;

    public Person (String name, String id, Gender gender){
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    //Getters
    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public Gender getGender() { return gender;}

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setId(String id) throws InvalidIDException {
        if (!id.matches("\\d+")){
            throw new InvalidIDException("The ID must contain only numbers");
        }
        this.id = id;
    }

    public String getInfo(){
        return "Name: " + name + " Identification " + id;
    }
}
