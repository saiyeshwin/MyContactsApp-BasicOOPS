# My Contacts App - Basic OOPS \\
## UC-01: User Registration
A new user registers by providing name, email, password, phone number, city, and account type (FREE/PREMIUM). The system validates input details and securely stores user credentials before creating the account.

## UC-02: User Authentication
A registered user logs in using Basic Authentication or OAuth. The system verifies credentials and grants access to contact management features upon successful authentication.

## UC-03: User Profile Management
A logged-in user can update city, change password, and update phone number. The system validates inputs and ensures secure handling of sensitive data.

## UC-04: Create Contact
A logged-in user creates a contact as either a Person or Organization. The user can add multiple phone numbers and email addresses. Each contact is stored with associated details for proper organization.

## UC-05: View Contact Details
The user views all saved contacts or selects a specific contact to see detailed information including phone numbers and email addresses formatted clearly.

## UC-06: Edit Contact
The user updates contact details such as name, phone numbers, or email addresses. The system validates changes and maintains data consistency.

## UC-07: Delete Contact
The user deletes a selected contact after confirmation. The system removes the contact while ensuring the integrity of the remaining data.

## UC-08: Bulk Operations
The user performs bulk actions such as viewing all persons, viewing all organizations, exporting all contacts, or deleting multiple contacts by selecting indexes. The system processes selected contacts in a single operation.

## UC-09: Search Contacts
The user searches contacts by name, phone number, or email. The system compares user input with stored records using string matching and returns matching results through separate search classes.

## UC-10: Basic Filtering
The user applies filters such as tag, recently added, or frequently contacted. The system sorts and displays contacts accordingly using Comparator and collection-based sorting.

## UC-11: Create and Manage Tags
The user creates, views, and deletes custom tags such as Family, Work, or Friends. Tags are stored using a Set collection to prevent duplication and maintain uniqueness.

## UC-12: Apply Tags to Contacts
The user assigns one or multiple existing tags to selected contacts. The system maintains the relationship between Contact and Tag objects using a Set collection to avoid duplicate assignments.

