// Use Case-4: Create Contact
// User adds a new contact with name, phone numbers, email addresses
// It uses list,LocalDateTime for timestamps, UUID for unique IDs
// @author Developer
// @version 4.0
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
        while (true) {
            System.out.println("1. Update City");
            System.out.println("2. Change Password");
            System.out.println("3. Update Phone");
            System.out.println("4. Create Contact");
            System.out.println("5. View Contacts");
            System.out.println("6. Exit");

            int option = sc.nextInt();
            sc.nextLine();
            
            switch (option) {
                case 1:
                    System.out.print("Enter New City: ");
                    String newCity = sc.nextLine();
                    loggedUser.updateCity(newCity);
                    System.out.println("City updated successfully!");
                    break;

                case 2:
                    System.out.print("Enter Old Password: ");
                    String oldPass = sc.nextLine();
                    System.out.print("Enter New Password: ");
                    String newPass = sc.nextLine();
                    if (loggedUser.verifyPassword(oldPass)) {
                        loggedUser.changePassword(newPass);
                        System.out.println("Password changed successfully!");
                    } else {
                        System.out.println("Incorrect old password!");
                    }
                    break;

                case 3:
                    System.out.print("Enter New Phone: ");
                    long newPhone = sc.nextLong();
                    sc.nextLine();
                    loggedUser.updatePhone(newPhone);
                    System.out.println("Phone updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter Contact Name: ");
                    String contactName = sc.nextLine();
                    Contact contact = new Person(contactName);          
                    System.out.print("How many phone numbers? ");
                    int phoneCount = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < phoneCount; i++) {
                        System.out.print("Enter Phone: ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("Enter Type (Home/Work/Mobile): ");
                        String typePhone = sc.nextLine();
                        contact.addPhone(new PhoneNumber(phoneNumber, typePhone));
                    }
                    System.out.print("How many emails? ");
                    int emailCount = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < emailCount; i++) {
                        System.out.print("Enter Email: ");
                        String emailAddr = sc.nextLine();
                        System.out.print("Enter Type (Personal/Work): ");
                        String typeEmail = sc.nextLine();

                        contact.addEmail(new Email(emailAddr, typeEmail));
                    }
                    loggedUser.addContact(contact);
                    System.out.println("Contact Created Successfully!");
                    break;

                case 5:
                    loggedUser.viewContacts();
                    break;

                case 6:
                    System.out.println("Exiting");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
