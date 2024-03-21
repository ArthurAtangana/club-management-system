package views;

import ui.ClubManagementCLI;

/**
 * Class representing the login view for the Club Management CLI.
 *
 * @author Braeden Kloke
 * @version March 18, 2024
 */
public class LoginView extends View {

    public LoginView(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
        // Construct flow from prompts to log user into the system.
        //   See diagrams/state.png for additional context.
        View authenticatingUserView = new AuthenticatingUserView(context);
        View passwordPrompt = new Prompt(context, "Enter password: ", authenticatingUserView);
        View userIdPrompt = new Prompt(context, "Enter user ID: ", passwordPrompt);
        context.setView(userIdPrompt);
    }
}
