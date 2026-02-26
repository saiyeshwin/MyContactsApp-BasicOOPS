package com.seveneleven.mycontactsapp;

public class User {
	 protected String name;
	 protected String email;
	 protected String passwordHash;
	 protected String userType; // FREE or PREMIUM
	 protected UserProfile profile;

	 public User(String name, String email, String passwordHash, 
	             String userType, UserProfile profile) {
	     this.name = name;
	     this.email = email;
	     this.passwordHash = passwordHash;
	     this.userType = userType;
	     this.profile = profile;
	 }

	 // Getters
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
	}