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
	public String getNumber() {
		// TODO Auto-generated method stub
		return number;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}