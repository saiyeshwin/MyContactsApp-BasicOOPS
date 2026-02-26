package com.seveneleven.mycontactsapp;

public class UserRegistration {
    public User register(String name, String email, String password,
                         long phone, String city, String userType) throws Exception {

    	  if (!Validator.isValidEmail(email)) {
              throw new IllegalArgumentException("Invalid email!");
          }
          if (!Validator.isValidPassword(password)) {
              throw new IllegalArgumentException("Weak password!");
          }
        String hashed = Hashing.hashPassword(password);
        UserProfile profile = new UserProfile(city, phone);
        User user = new User(name,email,hashed,userType,profile);
        if (user.getUserType().equalsIgnoreCase("free")) return new FreeUser(user);  
        else return new PremiumUser(user);
    }
}