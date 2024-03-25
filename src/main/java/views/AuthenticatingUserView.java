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
        String userId = context.getUserInput(1);
        String password = context.getUserInput(0);

        // Authenticate user
        System.out.println("Authenticating user ...");
        if (profileController.authenticate(userId, password)) {
            System.out.println("User authenticated.");
            // Set user for this session
            context.setUser(profileController.getUser(userId));
            context.setView(new MemberDashboard(context));
        } else {
            System.out.println("Username or password is invalid.");
            context.setView(new LoginView(context));
        }
    }
}
