
package com.seveneleven.mycontactsapp;

import java.util.Map;

public class BasicAuth implements Authentication {

    private Map<String, User> userDatabase;

    public BasicAuth(Map<String, User> userDatabase) {
        this.userDatabase = userDatabase;
    }

    @Override
    public boolean authenticate(String email, String password) {
        if (!userDatabase.containsKey(email)) {
            System.out.println("User not found!");
            return false;
        }

        User user = userDatabase.get(email);
        String hashedPassword = Hashing.hashPassword(password);

        if (user.getPasswordHash().equals(hashedPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid password!");
            return false;
        }
    }
}
