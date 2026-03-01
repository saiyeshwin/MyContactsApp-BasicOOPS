package com.seveneleven.mycontactsapp;
public class Organization extends Contact {
    private String registrationNumber;
    public Organization(String name, String registrationNumber) {
        super(name);
        this.registrationNumber = registrationNumber;
    }
    public Organization(String name) {
		// TODO Auto-generated constructor stub
    	 super(name);
    	
	}
	public String getContactType(){
    	return "ORGANIZATION";
    }
    public void display() {
        System.out.println("Organization Contact");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Registration No: " + registrationNumber);
        System.out.println("Created At: " + createdAt);
        System.out.println("Phones:");
        for (PhoneNumber p : phones)
            System.out.println(p);
        System.out.println("Emails:");
        for (Email e : emails)
            System.out.println(e);
    }
}