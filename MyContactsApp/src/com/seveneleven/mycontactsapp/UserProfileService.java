package com.seveneleven.mycontactsapp;

public class UserProfileService {

    public void changePassword(User user, String oldPassword, String newPassword) {

        if (!user.verifyPassword(oldPassword)) {
            System.out.println("Old password incorrect.");
            return;
        }

        user.changePassword(newPassword);
        System.out.println("Password updated successfully.");
    }

    public void updateEmail(User user, String newEmail) {
        user.updateEmail(newEmail);
        System.out.println("Email updated successfully.");
    }

    public void updatePreference(User user, String preference) {
        user.updatePreference(preference);
        System.out.println("Preference updated.");
    }
}