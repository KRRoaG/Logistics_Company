package com.solvd.logistic.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NA("N/A");  //to use when gender does not care

    private final String label;
    Gender(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
