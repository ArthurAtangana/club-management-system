package main.views;

import main.controllers.LoginController;
import main.controllers.UserController;
import main.ClubManagementCLI;

/**
 * Class representing the password prompt for logging into the system.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class PasswordLoginPrompt extends View {

    public PasswordLoginPrompt(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void printInfo() {
        System.out.println("Enter password:");
    }

    @Override
    public void handleUserInput() {
        LoginController loginController = new LoginController();
        UserController profileController = new UserController();
        String username = (String) context.getBuffer();
        String password = context.getUserInput();

        // Authenticate user
        if (loginController.authenticate(username, password)) {
            // Set user for this session
            context.setUser(profileController.getUser(username));
            context.setView(new MemberDashboard(context));
        } else {
            System.out.println("Username or password is invalid.");
            context.setView(new UsernameLoginPrompt(context));
        }
    }
}
