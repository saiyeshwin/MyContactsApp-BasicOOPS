package com.seveneleven.mycontactsapp;
import java.util.*;
public class SearchByEmail implements ContactSearch {
    public List<Contact> search(List<Contact> contacts, String emailAddress) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            for (Email email : contact.getEmails()) {
                if (email.getEmail().equalsIgnoreCase(emailAddress) ||
                    email.getEmail().toLowerCase().contains(emailAddress.toLowerCase())) {
                    result.add(contact);
                    break;
                }
            }
        }
        return result;
    }
}

