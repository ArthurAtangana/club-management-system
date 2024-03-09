package main.views;

import main.ClubManagementCLI;

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
