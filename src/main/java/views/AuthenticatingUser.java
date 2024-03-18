package views;

import controllers.UserController;
import ui.ClubManagementCLI;

/**
 * Class representing the view for authenticating a user in the system.
 *
 * @author Braeden Kloke
 * @version March 18, 2024
 */
public class AuthenticatingUser extends View {

    public AuthenticatingUser(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
        UserController profileController = new UserController();
        String username = (String) context.getBuffer();
        String password = context.getUserInput();

        // Authenticate user
        System.out.println("Authenticating user ...");
        if (profileController.authenticate(username, password)) {
            System.out.println("User authenticated.");
            // Set user for this session
            context.setUser(profileController.getUser(username));
            context.setView(new MemberDashboard(context));
        } else {
            System.out.println("Username or password is invalid.");
            context.setView(new UsernameLoginPrompt(context));
        }
    }
}
