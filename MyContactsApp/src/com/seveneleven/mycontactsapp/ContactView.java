package com.seveneleven.mycontactsapp;

public class ContactView {

    private Contact contact;

    public ContactView(Contact contact) {
        this.contact = contact;
    }

    public String getFormattedDetails() {
        String phoneDetails = "";
        for (PhoneNumber phone : contact.getPhones()) {
            phoneDetails += phone.getNumber() + " (" + phone.getType() + ") ";
        }

        String emailDetails = "";
        for (Email email : contact.getEmails()) {
            emailDetails += email.getAddress() + " (" + email.getType() + ") ";
        }

        return  "ID: " + contact.getId() + "\n" +
                "Name: " + contact.getName() + "\n" +
                "Phones: " + phoneDetails.trim() + "\n" +
                "Emails: " + emailDetails.trim() + "\n" +
                "Created: " + contact.getCreatedAt();
    }
}
