package com.solvd.logistic.service;

public abstract class LogisticOperation {
    private String date;

    public LogisticOperation(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public abstract void executeOperation();
}
