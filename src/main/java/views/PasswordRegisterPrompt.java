package views;

import controllers.UserController;
import ui.ClubManagementCLI;

/**
 * Class representing the prompt to register a new user's password.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class PasswordRegisterPrompt extends View {

    public PasswordRegisterPrompt(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void printInfo() {
        System.out.println("Enter password:");
    }

    @Override
    public void handleUserInput() {
        UserController registerController = new UserController();
        String username = (String) context.getBuffer();
        String password = context.getUserInput();

        System.out.println("Registering user ...");
        registerController.register(username, password);
        System.out.println("User registered.");
        context.setView(new HomeScreen(context));
    }
}
