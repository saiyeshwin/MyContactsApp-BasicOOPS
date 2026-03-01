package com.seveneleven.mycontactsapp;
import java.util.*;
public class SearchByName implements ContactSearch {
    public List<Contact> search(List<Contact> contacts, String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name) ||
                contact.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(contact);
            }
        }
        return result;
    }
}