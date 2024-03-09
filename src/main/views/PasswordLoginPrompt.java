package main.views;

import main.controllers.LoginController;
import main.controllers.UserController;
import main.ClubManagementCLI;

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
        String username = (String) context.getBuffer();
        String password = context.getUserInput();

        // Authenticate user
        if (loginController.authenticate(username, password)) {
            UserController profileController = new UserController();
            context.setUser(profileController.getUser(username));
            context.setView(new MemberDashboard(context));
        } else {
            context.setView(new UsernameLoginPrompt(context));
        }
    }
}
