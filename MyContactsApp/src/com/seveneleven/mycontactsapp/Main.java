// Use Case-3: User Profile Management
// User updates profile information,changes password,or manages preferences
// User can update city, phone number, password
// @author Developer
// @version 3.0
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
        if (!success) {
            System.out.println("Invalid email or password!");
            return;
        }
        User loggedUser = userDatabase.get(loginEmail);
        System.out.println("Welcome " + loggedUser.getName());
        System.out.println("1. Update City");
        System.out.println("2. Change Password");
        System.out.println("3. Update Phone");
        System.out.println("4. Exit");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter New City: ");
                String newCity = sc.nextLine();
                loggedUser.updateCity(newCity);
                System.out.println("City updated successfully!");
                loggedUser.displayProfile();
                break;
            case 2:
                System.out.print("Enter Old Password: ");
                String oldPass = sc.nextLine();
                System.out.print("Enter New Password: ");
                String newPass = sc.nextLine();
                if (loggedUser.verifyPassword(oldPass)) {
                    loggedUser.changePassword(newPass);
                    System.out.println("Password changed successfully!");
                } 
                else {
                    System.out.println("Incorrect old password!");
                }
                break;
            case 3:
                System.out.print("Enter New Phone: ");
                long newPhone = sc.nextLong();
                loggedUser.updatePhone(newPhone);
                System.out.println("Phone updated successfully!");
                loggedUser.displayProfile();
                break;
            default:
                System.out.println("Exiting Profile Management.");
        }
    }
}
