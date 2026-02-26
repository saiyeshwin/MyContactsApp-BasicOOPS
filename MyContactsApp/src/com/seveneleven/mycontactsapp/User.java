package com.seveneleven.mycontactsapp;
public class User {

	protected String name;
	protected String email;
	protected String passwordHash;
	protected String userType;
	protected UserProfile profile;
	private String preference;

	public User(String name, String email, String passwordHash, 
			String userType, UserProfile profile) {
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.userType = userType;
		this.profile = profile;
	}
	public String getName() { 
		return name; 
	}
	public String getEmail() { 
		return email; 
	}
	public String getPasswordHash() { 
		return passwordHash; 
	}
	public String getUserType() { 
		return userType; 
	}
	public UserProfile getUserProfile() { 
		return profile; 
	}
	public String getPreference() {
		return preference;
	}

	public void updateEmail(String newEmail) {
		if (!Validator.isValidEmail(newEmail)) {
			throw new IllegalArgumentException("Invalid email format");
		}
		this.email = newEmail;
	}
	public void updateCity(String newCity) {
		this.profile.setCity(newCity);
	}
	public void changePassword(String newPassword) {
		if (!Validator.isValidPassword(newPassword)) {
			throw new IllegalArgumentException("Weak password");
		}
		this.passwordHash = Hashing.hashPassword(newPassword);
	}
	public boolean verifyPassword(String inputPassword) {
		return this.passwordHash.equals(Hashing.hashPassword(inputPassword));
	}
	public void updatePreference(String newPreference) {
		this.preference = newPreference;
	}
	public void updatePhone(long newPhone) {
		this.profile.setPhoneNumber(newPhone);
	}
	public void displayProfile() {
		 System.out.println("Name: " +name);
         System.out.println("Email: " + email);
         System.out.println("User Type: " + userType);
         System.out.println("Phone: " +profile.getPhoneNumber());
         System.out.println("City: " + profile.getCity());
	}
}