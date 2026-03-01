// Use Case-10: Filter Contacts
// User can filter contacts by date, frequently contacted
// @author Developer
// @version 10.0
package com.seveneleven.mycontactsapp;
import java.util.*;
public class Main {
    private static Map<String, User> userDatabase = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
            System.out.println("9. Bulk Operations");
            System.out.println("10. Basic Filtering");
            System.out.println("11. Exit");

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
                	System.out.print("Enter Contact Type (1. Person  2. Organization): ");
                	int contactTypeChoice = sc.nextInt();
                	sc.nextLine();
                	Contact contact;
                	if (contactTypeChoice == 1) {
                	    contact = new Person(contactName);
                	} 
                	else if (contactTypeChoice == 2) {
                	    contact = new Organization(contactName);
                	} 
                	else {
                	    System.out.println("Invalid type. Defaulting to Person.");
                	    contact = new Person(contactName);
                	}
       
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
                        break;
                    }
                    System.out.println("SEARCH CONTACT ");
                    System.out.println("1. Search By Name");
                    System.out.println("2. Search By Phone");
                    System.out.println("3. Search By Email");
                    System.out.print("Choose option: ");

                    int searchChoice = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter search keyword: ");
                    String keyword = sc.nextLine();
                    ContactSearch searchStrategy = null;
                    if (searchChoice == 1) {
                        searchStrategy = new SearchByName();
                    } 
                    else if (searchChoice == 2) {
                        searchStrategy = new SearchByPhone();
                    } 
                    else if (searchChoice == 3) {
                        searchStrategy = new SearchByEmail();
                    } 
                    else {
                        System.out.println("Invalid search option.");
                        break;
                    }
                    List<Contact> results = searchStrategy.search(contacts, keyword);
                    if (results.isEmpty()) {
                        System.out.println("No matching contacts found.");
                    } 
                    else {
                        System.out.println("---- Search Results ----");
                        for (Contact c : results) {
                            System.out.println(c.getName());
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
                    BulkOperations bulkService = new BulkOperations();
                    List<Contact> contactList = loggedUser.getContacts();
                    if (contactList.isEmpty()) {
                        System.out.println("No contacts available.");
                        break;
                    }

                    System.out.println("Contact List:");
                    for (int i = 0; i < contactList.size(); i++) {
                        System.out.println((i + 1) + ". " + contactList.get(i).getName());
                    }
                    System.out.println("1. Show All Persons");
                    System.out.println("2. Show All Organizations");
                    System.out.println("3. Export All Contacts");
                    System.out.println("4. Bulk Delete (Select Indexes)");
                    System.out.print("Choose option:");

                    int bulkChoice = sc.nextInt();
                    sc.nextLine();

                    switch (bulkChoice) {
                        case 1:
                            bulkService.showAllPersons(contactList);
                            break;
                        case 2:
                            bulkService.showAllOrganizations(contactList);
                            break;
                        case 3:
                            bulkService.exportAllContacts(contactList);
                            break;
                        case 4:
                            System.out.print("Enter indexes separated by space:");
                            String input = sc.nextLine();
                            String[] parts = input.split(" ");
                            List<Integer> indexes = new ArrayList<>();
                            for (String part : parts) {
                                try {
                                    int idx = Integer.parseInt(part) - 1;
                                    indexes.add(idx);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid number: " + part);
                                }
                            }
                            bulkService.bulkDeleteByIndexes(contactList, indexes);
                            break;
                        default:
                            System.out.println("Invalid bulk option.");
                    }
                    break;
                case 10:
                    List<Contact> contactsList = loggedUser.getContacts();
                    if (contactsList.isEmpty()) {
                        System.out.println("No contacts available.");
                        break;
                    }
                    System.out.println("FILTER ");
                    System.out.println("1. Filter By Tag");
                    System.out.println("2. Recently Added");
                    System.out.println("3. Frequently Contacted");
                    System.out.print("Choose option: ");
                    int filterChoice = sc.nextInt();
                    sc.nextLine();
                    ContactFilter filter = null;
                    if (filterChoice == 1) {
                        System.out.print("Enter tag: ");
                        String tag = sc.nextLine();
                        filter = new FilterByTag(tag);

                    } 
                    else if (filterChoice == 2) {
                        filter = new FilterByRecent();
                    } 
                    else if (filterChoice == 3) {
                        filter = new FilterByFrequency();
                    } 
                    else {
                        System.out.println("Invalid filter option.");
                        break;
                    }
                    List<Contact> filteredResults = filter.filter(contactsList);

                    System.out.println("Filter Results:");

                    for (Contact c : filteredResults) {
                        System.out.println(c.getName());
                    }

                    break;
                case 11:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
