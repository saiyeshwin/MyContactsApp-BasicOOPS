package com.seveneleven.mycontactsapp;

public class PremiumUser extends User {

	 public PremiumUser(User user) {
	     // super(user.name, user.email, user.passwordHash,"PREMIUM", user.profile);
	     super(user.getName(), user.getEmail(), user.getPasswordHash(),"PREMIUM", user.getUserProfile());

	 }
	}
