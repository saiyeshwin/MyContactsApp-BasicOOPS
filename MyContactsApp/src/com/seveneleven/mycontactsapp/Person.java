package com.seveneleven.mycontactsapp;

import java.util.ArrayList;

public class Person extends Contact {
    public Person(String name) {
        super(name);
    }
    public void setName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = newName;
    }

	public void display() {
        System.out.println("Person Contact");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Created At: " + createdAt);

        System.out.println("Phones:");
        for (PhoneNumber p : phones)
            System.out.println(p);

        System.out.println("Emails:");
        for (Email e : emails)
            System.out.println(e);
    }
}