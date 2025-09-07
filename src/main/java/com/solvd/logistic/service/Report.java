package com.solvd.logistic.service;

public class Report {
    private String code;
    private String message;
    private String date;

    public Report(String code, String message, String date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Report { Code: " + code +
                ", Message: " + message +
                ", Date: " + date + " }";
    }
}
