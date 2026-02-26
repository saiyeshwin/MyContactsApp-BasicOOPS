package com.seveneleven.mycontactsapp;

public class UserProfile {
	private String city;
	private long phoneNumber;
	public UserProfile(String city, long phoneNumber) {
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}