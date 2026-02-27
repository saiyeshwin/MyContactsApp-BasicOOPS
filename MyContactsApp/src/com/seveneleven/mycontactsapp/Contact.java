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
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}