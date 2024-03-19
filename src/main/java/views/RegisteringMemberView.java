package views;

import ui.ClubManagementCLI;

/**
 * Class representing the view when authenticating a user into the system.
 */
public class RegisteringMemberView extends View {

    public RegisteringMemberView(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
       context.setView(new HomeScreen(context));
    }
}
