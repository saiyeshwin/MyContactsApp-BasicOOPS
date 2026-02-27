package com.seveneleven.mycontactsapp;
public class PhoneNumber {
    private String number;
    private String type;
    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }
    public PhoneNumber(PhoneNumber phone) {
		// TODO Auto-generated constructor stub
    	this.number=phone.number;
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
	public void setNumber(String newPhoneNum) {
		// TODO Auto-generated method stub
		this.number=newPhoneNum;
	}
	public void setType(String newPhoneType) {
		// TODO Auto-generated method stub
		this.type=newPhoneType;
		
	}
}