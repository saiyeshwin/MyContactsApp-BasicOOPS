package com.seveneleven.mycontactsapp;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            long phone = Long.parseLong(sc.nextLine());
            System.out.print("Enter City:");
            String city = sc.nextLine();
            System.out.print("Enter User Type(FREE/PREMIUM): ");
            String userType = sc.nextLine();
            UserRegistration service = new UserRegistration();
            User user = service.register(name,email,password,phone,city,userType);
            System.out.println("\nRegistration Successful!");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("User Type: " + user.getUserType());
            System.out.println("Phone: " + user.getUserProfile().getPhoneNumber());
            System.out.println("City: " + user.getUserProfile().getCity());
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}