package com.solvd.logistic.service;

public record Report (String code, String message, String date){
    @Override
    public String toString() {
        return "Report { Code: " + code +
                ", Message: " + message +
                ", Date: " + date + " }";
    }
}
