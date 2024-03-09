package main.views;

import main.ClubManagementCLI;

/**
 * Class representing the view to register a new user's username.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class UsernameRegisterPrompt extends View {

    public UsernameRegisterPrompt(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void printInfo() {
        printLineBreak();
        System.out.println("Enter username:");
    }

    @Override
    public void handleUserInput() {
        context.setView(new HomeScreen(context));
    }
}
