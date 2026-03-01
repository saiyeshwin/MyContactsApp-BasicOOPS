package com.seveneleven.mycontactsapp;
public class Email {
    private String email;
    private String type;
    public Email(String email, String type) {
        this.email = email;
        this.type = type;
    }
    public Email(Email e) {
    	this.email=e.email;
	}
	public String toString() {
        return type + ": " + email;
    }
	public String getAddress() {
		return email;
	}
	public String getType() {
		return type;
	}
	public void setEmail(String email) {
	    if (!email.contains("@")) {
	        throw new IllegalArgumentException("Invalid email");
	    }
	    this.email = email;
	}
	public void setType(String type) {
	    this.type = type;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

}