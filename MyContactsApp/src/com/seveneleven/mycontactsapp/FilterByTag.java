package com.seveneleven.mycontactsapp;
import java.util.*;
public class FilterByTag implements ContactFilter {
    private String tag;
    public FilterByTag(String tag) {
        this.tag = tag;
    }
    public List<Contact> filter(List<Contact> contacts) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getTags().contains(tag)) {
                result.add(contact);
            }
        }
        return result;
    }
}
