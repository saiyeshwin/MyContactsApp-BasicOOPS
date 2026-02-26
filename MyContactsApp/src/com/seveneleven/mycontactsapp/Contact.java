package com.seveneleven.mycontactsapp;
import java.time.LocalDateTime;
import java.util.*;
public abstract class Contact {
    protected UUID id;
    protected String name;
    protected List<PhoneNumber> phones;
    protected List<Email> emails;
    protected LocalDateTime createdAt;
    public Contact(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phones = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }
    public void addPhone(PhoneNumber phone) {
        phones.add(phone);
    }
    public void addEmail(Email email) {
        emails.add(email);
    }
    public abstract void display();
}