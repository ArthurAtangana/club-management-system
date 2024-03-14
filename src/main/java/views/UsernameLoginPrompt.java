package views;

import ui.ClubManagementCLI;

/**
 * Class representing the login prompt to retrieve the username.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class UsernameLoginPrompt extends View {

    public UsernameLoginPrompt(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void printInfo() {
        printLineBreak();
        System.out.println("Enter username:");
    }

    @Override
    public void handleUserInput() {
        // Store username in buffer to use in authentication
        context.setBuffer(context.getUserInput());
        context.setView(new PasswordLoginPrompt(context));
    }
}
