package com.seveneleven.mycontactsapp;
import java.util.*;
public class FilterByFrequency implements ContactFilter {
    public List<Contact> filter(List<Contact> contacts) {
        List<Contact> sortedList = new ArrayList<>(contacts);
        Collections.sort(sortedList, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c2.getContactCount() - c1.getContactCount();
            }
        });
        return sortedList;
    }
}
