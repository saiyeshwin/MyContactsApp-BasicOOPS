package com.seveneleven.mycontactsapp;
import java.util.*;
public class SearchByPhone implements ContactSearch {
    public List<Contact> search(List<Contact> contacts, String phoneNumber) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            for (PhoneNumber phone : contact.getPhones()) {
                if (phone.getNumber().contains(phoneNumber)) {
                    result.add(contact);
                    break;
                }
            }
        }
        return result;
    }
}
