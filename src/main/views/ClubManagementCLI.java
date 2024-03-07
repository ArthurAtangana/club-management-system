package main.views;

import main.controllers.*;
import main.models.*;

import java.util.Scanner;

/**
 * Class representing the command line interface (CLI) for the
 * Health and Fitness Club Management System.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 * Initialize member use cases.
 */
public class ClubManagementCLI {

    private UserProfile user; // User logged into system
    private ProfileController profileController;

    public ClubManagementCLI() {

        // Initialize system
        user = null;
        profileController = new ProfileController();

        // Log user into system
        if (login()) {
            displayDashboard(user.getUsername());
        }
    }

    /**
     * Prompts user for username and password. Logs user into system
     * if login attempt is valid.
     *
     * @return True if valid login attempt, false otherwise.
     *
     * @author Braeden Kloke
     */
    private boolean login() {
        String username, password;
        LoginController loginController = new LoginController();
        Scanner scanner = new Scanner(System.in);

        // prompt user for username and password
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        // authenticate user
        if (loginController.authenticate(username, password)) {
            user = profileController.getProfile(username);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Displays the system dashboard for a given user.
     *
     * @author Braeden Kloke
     */
    private void displayDashboard(String username) {
        // get user's profile
        ProfileController profileController = new ProfileController();
        UserProfile profile  = profileController.getProfile(username);

        // display profile
        System.out.println(profile.toString());
    }
}
