package views;

import ui.ClubManagementCLI;
import controllers.UserController;

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
        context.setView(new AuthenticatingUser(context));
    }
}
