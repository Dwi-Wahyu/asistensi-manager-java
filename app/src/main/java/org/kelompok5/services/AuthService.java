package org.kelompok5.services;

public class AuthService {
    private String loggedInUser = null;

    // Contoh data dummy
    private final String DUMMY_USERNAME = "admin";
    private final String DUMMY_PASSWORD = "1234";

    public boolean login(String username, String password) {
        if (username.equals(DUMMY_USERNAME) && password.equals(DUMMY_PASSWORD)) {
            loggedInUser = username;
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = null;
    }
}
