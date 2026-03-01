package com.seveneleven.mycontactsapp;
import java.time.LocalDateTime;
import java.util.*;
public abstract class Contact {
	protected UUID id;
	protected String name;
	protected List<PhoneNumber> phones;
	protected List<Email> emails;
	protected LocalDateTime createdAt;
	private Date dateAdded = new Date();
	private int contactCount = 0;
	private Set<Tag> tags = new HashSet<>();

	public Contact(String name) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.phones = new ArrayList<>();
		this.emails = new ArrayList<>();
		this.createdAt = LocalDateTime.now();
	}
	public Contact(Contact other) {
		this.name = other.name;
		this.phones = new ArrayList<>();
		for (PhoneNumber p : other.phones) {
			this.phones.add(new PhoneNumber(p));
		}
		this.emails = new ArrayList<>();
		for (Email e : other.emails) {
			this.emails.add(new Email(e));
		}
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
	public abstract String getContactType();
	public Date getDateAdded() {
		return dateAdded;
	}

	public int getContactCount() {
		return contactCount;
	}

	public void incrementContactCount() {
		contactCount++;
	}

	public Set<Tag> getTags() {
		return tags;
	}
	public void addTag(Tag tag) {
		tags.add(tag);
	}
}
