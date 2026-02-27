// Use Case-7: Delete Contacts
// User removes a contact from the list of contacts
// @author Developer
// @version 7.0
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
        String loginPassword=null;
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
            System.out.println("6. Search Contact");
            System.out.println("7. Edit Contact");
            System.out.println("8. Delete Contact");
            System.out.println("9. Exit");


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
                    List<Contact> contacts = loggedUser.getContacts();
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        System.out.print("Enter contact name to view: ");
                        String searchName = sc.nextLine();
                        boolean found = false;
                        for (Contact c : contacts) {
                            if (c.getName().equalsIgnoreCase(searchName)) {
                                ContactView view = new ContactView(c);
                                System.out.println(view.getFormattedDetails());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Contact not found!");
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter contact name to modify: ");
                    String modifyName = sc.nextLine();
                    Contact target = null;
                    for (Contact c : loggedUser.getContacts()) {
                        if (c.getName().equalsIgnoreCase(modifyName)) {
                            target = c;
                            break;
                        }
                    }
                    if (target == null) {
                        System.out.println("Contact not found!");
                        break;
                    }

                    System.out.println("Choose field to modify:");
                    System.out.println("1. Add Phone");
                    System.out.println("2. Add Email");
                    System.out.println("3. Update Name");
                    System.out.println("4. Edit Existing Phone"); 
                    System.out.println("5. Edit Existing Email");
                    
                    int modChoice = sc.nextInt();
                    sc.nextLine();

                    switch (modChoice) {
                        case 1:
                            System.out.print("Enter Phone: ");
                            String newPhoneNumber = sc.nextLine();
                            System.out.print("Enter Type (Home/Work/Mobile): ");
                            String typePhone = sc.nextLine();
                            target.addPhone(new PhoneNumber(newPhoneNumber, typePhone));
                            break;
                        case 2:
                            System.out.print("Enter Email: ");
                            String newEmail = sc.nextLine();
                            System.out.print("Enter Type (Personal/Work): ");
                            String typeEmail = sc.nextLine();
                            target.addEmail(new Email(newEmail, typeEmail));
                            break;
                        case 3:
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();
                            target.setName(newName);
                            break;
                        case 4:
                            List<PhoneNumber> phones = target.getPhones();
                            if (phones.isEmpty()) {
                                System.out.println("No phones to edit.");
                                break;
                            }
                            for (int i = 0; i < phones.size(); i++) {
                                System.out.println((i+1) + ". " + phones.get(i).toString());
                            }
                            System.out.print("Choose phone index to edit: ");
                            int phoneIndex = sc.nextInt() - 1;
                            sc.nextLine();
                            if (phoneIndex < 0 || phoneIndex >= phones.size()) {
                                System.out.println("Invalid index!");
                                break;
                            }
                            System.out.print("Enter new phone number: ");
                            String newPhoneNum = sc.nextLine();
                            System.out.print("Enter new type (Home/Work/Mobile): ");
                            String newPhoneType = sc.nextLine();
                            phones.get(phoneIndex).setNumber(newPhoneNum);
                            phones.get(phoneIndex).setType(newPhoneType);
                            System.out.println("Phone updated successfully!");
                            break;

                        case 5:
                            List<Email> emails = target.getEmails();
                            if (emails.isEmpty()) {
                                System.out.println("No emails to edit.");
                                break;
                            }
                            for (int i = 0; i < emails.size(); i++) {
                                System.out.println((i+1) + ". " + emails.get(i).toString());
                            }
                            System.out.print("Choose email index to edit: ");
                            int emailIndex = sc.nextInt() - 1;
                            sc.nextLine();
                            if (emailIndex < 0 || emailIndex >= emails.size()) {
                                System.out.println("Invalid index!");
                                break;
                            }
                            System.out.print("Enter new email address: ");
                            String newEmailAddr = sc.nextLine();
                            System.out.print("Enter new type (Personal/Work): ");
                            String newEmailType = sc.nextLine();
                            emails.get(emailIndex).setEmail(newEmailAddr);
                            emails.get(emailIndex).setType(newEmailType);
                            System.out.println("Email updated successfully!");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }

                    System.out.println("Contact updated successfully!");
                    break;
                case 8:
                    List<Contact> contactsToDelete = loggedUser.getContacts();
                    if (contactsToDelete.isEmpty()) {
                        System.out.println("No contacts available to delete.");
                        break;
                    }

                    System.out.print("Enter contact name to delete: ");
                    String deleteName = sc.nextLine();
                    Contact targetDelete = null;
                    for (Contact c : contactsToDelete) {
                        if (c.getName().equalsIgnoreCase(deleteName)) {
                            targetDelete = c;
                            break;
                        }
                    }

                    if (targetDelete == null) {
                        System.out.println("Contact not found!");
                        break;
                    }
                    System.out.print("Are you sure you want to delete " + targetDelete.getName() + "? (Y/N): ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        contactsToDelete.remove(targetDelete);
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                    break;

                case 9:
                    System.out.println("Exiting");
                    return;
           
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
