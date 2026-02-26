package com.seveneleven.mycontactsapp;
import java.util.*;
public class Main {
    private static Map<String, User> userDatabase = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserRegistration registration = new UserRegistration();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Phone: ");
        long phone = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Type (FREE/PREMIUM): ");
        String type = sc.nextLine();
        try {
            User user = registration.register(name, email, password, phone, city, type);
            userDatabase.put(email, user);
            System.out.println("Registration Successful!");
        } 
        catch (Exception e) {
            System.out.println("Registration Failed: " + e.getMessage());
            return;
        }
        System.out.println("Choose Login Method:");
        System.out.println("1. Basic Authentication");
        System.out.println("2. OAuth");
        int choice = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Email: ");
        String loginEmail = sc.nextLine();
        String loginPassword = null;
        Authentication auth;
        if (choice == 1) {
            System.out.print("Enter Password: ");
            loginPassword = sc.nextLine();
            auth = new BasicAuth(userDatabase);
        } 
        else {
            auth = new OAuth();
        }
        boolean success = auth.authenticate(loginEmail, loginPassword);
        if (success) {
            User loggedUser = userDatabase.get(loginEmail);
            System.out.println("Welcome " + loggedUser.getName());
        } 
        else {
            System.out.println("Invalid email or password!");
        }
    }
}
