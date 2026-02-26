package com.seveneleven.mycontactsapp;

public class OAuth implements Authentication {

    @Override
    public boolean authenticate(String email, String password) {
        if (email.endsWith("@gmail.com")) {
            System.out.println("OAuth Login Successful via Google!");
            //Session session = new Session(email); // create a new session
            // You can now pass this session around instead of relying on Singleton
            return true;
        } else {
            System.out.println("OAuth Failed!");
            return false;
        }
    }
}
