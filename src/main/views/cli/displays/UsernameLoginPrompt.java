package main.views.cli.displays;

import main.views.cli.ClubManagementCLI;

public class UsernameLoginPrompt extends Display {

    public UsernameLoginPrompt(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void display() {
        System.out.println("Enter username:");
    }

    @Override
    public void handleUserInput() {
        context.setBuffer(context.getUserInput()); // temporarily store username
        context.setDisplay(new PasswordLoginPrompt(context));
    }
}
