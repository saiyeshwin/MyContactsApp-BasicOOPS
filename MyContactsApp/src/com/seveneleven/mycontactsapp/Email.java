package com.seveneleven.mycontactsapp;
public class Email {
    private String email;
    private String type;
    public Email(String email, String type) {
        this.email = email;
        this.type = type;
    }
    public String toString() {
        return type + ": " + email;
    }
	public String getAddress() {
		// TODO Auto-generated method stub
		return email;
	}
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}