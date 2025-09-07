package com.solvd.logistic.enums;

public enum Zone {
    NORTH(68089),
    EAST(68040),
    WEST(68020),
    SOUTH(68000);

    private final int postalCode;
    Zone(int postalCode){
        this.postalCode = postalCode;
    };

    public int getPostalCode(){
        return postalCode;
    }

}
