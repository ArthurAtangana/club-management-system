package main;

import main.controllers.LoginController;

import java.util.Scanner;

/**
 * Class representing the command line interface (CLI) for the
 * Health and Fitness Club Management System.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 * Implement login use case.
 */
public class ClubManagementCLI {

    public ClubManagementCLI() {
        login();
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
        Scanner scanner = new Scanner(System.in);
        LoginController loginController = new LoginController();

        // prompt user for username and password
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        // authenticate user
        return loginController.authenticate(username, password);
    }
}
