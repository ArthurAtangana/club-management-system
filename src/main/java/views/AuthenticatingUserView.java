package views;

import controllers.UserController;
import ui.ClubManagementCLI;

/**
 * Class representing the view for authenticating a user in the system.
 *
 * @author Braeden Kloke
 * @version March 18, 2024
 */
public class AuthenticatingUserView extends View {

    public AuthenticatingUserView(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
        UserController profileController = new UserController();
        String username = context.getUserInput(1);
        String password = context.getUserInput(0);

        // Authenticate user
        System.out.println("Authenticating user ...");
        if (profileController.authenticate(username, password)) {
            System.out.println("User authenticated.");
            // Set user for this session
            context.setUser(profileController.getUser(username));
            context.setView(new MemberDashboard(context));
        } else {
            System.out.println("Username or password is invalid.");
            context.setView(new LoginView(context));
        }
    }
}
