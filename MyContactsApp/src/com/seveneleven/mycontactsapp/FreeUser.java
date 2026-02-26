package com.seveneleven.mycontactsapp;

public class FreeUser extends User {

	 public FreeUser(User user) {
	     super(user.getName(), user.getEmail(), user.getPasswordHash(),"FREE", user.getUserProfile());
	 }
	}