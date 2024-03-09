package main.views;

import main.ClubManagementCLI;

public class UsernameLoginPrompt extends View {

    public UsernameLoginPrompt(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void displayInfo() {
        System.out.println("Enter username:");
    }

    @Override
    public void handleUserInput() {
        context.setBuffer(context.getUserInput()); // temporarily store username
        context.setView(new PasswordLoginPrompt(context));
    }
}
