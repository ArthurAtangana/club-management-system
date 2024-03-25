package views;

import ui.ClubManagementCLI;

/**
 * Class representing the super state to register a new member into the system.
 * See diagrams/state.png for additional context.
 *
 * @author Braeden Kloke
 * @version March 19, 2024
 */
public class RegisterView extends View {

    public RegisterView(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
        // Construct flow from prompts to register member in system.
        printLineBreak();
        View registering = new RegisteringMemberView(context);
        View passwordPrompt = new Prompt(context, "Enter password: ", registering);
        View emailPrompt = new Prompt(context, "Enter email: ", passwordPrompt);
        View lastNamePrompt = new Prompt(context, "Enter last name: ", emailPrompt);
        View firstNamePrompt = new Prompt(context, "Enter first name: ", lastNamePrompt);
        context.setView(firstNamePrompt);
    }
}
