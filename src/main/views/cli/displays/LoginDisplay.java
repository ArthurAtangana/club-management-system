package main.views.cli.displays;

import main.controllers.LoginController;
import main.controllers.ProfileController;
import main.views.cli.ClubManagementCLI;
import main.views.cli.commands.LoginCommand;

import java.util.Scanner;

/**
 * Class representing the login display for the Health and Fitness
 * Club System's CLI.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class LoginDisplay extends Display {

    public LoginDisplay(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
        String username, password;
        LoginController loginController = new LoginController();
        ProfileController profileController = new ProfileController();
        Scanner scanner = new Scanner(System.in);

        // Prompt user for username and password
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        // Authenticate user
        if (loginController.authenticate(username, password)) {
            System.out.println("User authenticated.");
            System.out.println("Logging in ...");
            context.setUser(profileController.getProfile(username));
            context.setDisplay(new MemberDisplay(context));
        } else {
            context.setDisplay(new LoginDisplay(context));
        }
    }
}
