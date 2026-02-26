package com.seveneleven.mycontactsapp;

import java.util.regex.Pattern;
public class Validator {
    public static boolean isValidEmail(String email) {
    	String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailRegex, email);
    }
    public static boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}