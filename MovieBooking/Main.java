package MovieBooking;

import MovieBooking.controller.LoginController;
import MovieBooking.view.LoginView;

/**
 * Main class - Entry point for Movie Booking Management System
 * Starts the application with Login screen
 */
public class Main {
    public static void main(String[] args) {
        // Start application with login screen
        LoginView loginView = new LoginView();
        new LoginController(loginView);
        loginView.setVisible(true);
    }
}