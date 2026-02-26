package com.seveneleven.mycontactsapp;
public class PhoneNumber {
    private String number;
    private String type;
    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }
    public String toString() {
        return type + ": " + number;
    }
}