package com.seveneleven.mycontactsapp;

import java.util.*;

public class BulkOperations {
    public void showAllPersons(List<Contact> contacts) {
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getContactType().equalsIgnoreCase("PERSON")) {
                System.out.println(contact.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Person contacts found.");
        }
    }

    public void showAllOrganizations(List<Contact> contacts) {

        System.out.println(" All Organization Contacts:");

        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getContactType().equalsIgnoreCase("ORGANIZATION")) {
                System.out.println(contact.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Organization contacts found.");
        }
    }
    public void exportAllContacts(List<Contact> contacts) {

        System.out.println("Exported Contacts:");

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact.getName());
        }
    }
    public void bulkDeleteByIndexes(List<Contact> contacts, List<Integer> indexes) {
        Collections.sort(indexes, Collections.reverseOrder());

        for (int index : indexes) {

            if (index >= 0 && index < contacts.size()) {
                System.out.println("Deleting: " + contacts.get(index).getName());
                contacts.remove(index);
            } else {
                System.out.println("Invalid index: " + (index + 1));
            }
        }

        System.out.println("Bulk delete completed.");
    }
}
