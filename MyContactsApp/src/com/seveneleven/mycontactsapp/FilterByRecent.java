package com.seveneleven.mycontactsapp;
import java.util.*;
public class FilterByRecent implements ContactFilter {
    public List<Contact> filter(List<Contact> contacts) {
        List<Contact> sortedList = new ArrayList<>(contacts);
        Collections.sort(sortedList, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c2.getDateAdded().compareTo(c1.getDateAdded());
            }
        });
        return sortedList;
    }
}
