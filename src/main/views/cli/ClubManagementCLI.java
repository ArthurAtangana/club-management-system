package main.views.cli;

import main.controllers.*;
import main.models.*;
import main.views.cli.displays.*;
import main.views.cli.commands.*;

import java.util.*;

/**
 * Class representing the command line interface (CLI) for the
 * Health and Fitness Club Management System.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 * Initialize member use cases.
 */
public class ClubManagementCLI {

    private UserProfile user; // User logged into system
    private ProfileController profileController;
    private Scanner scanner;
    private Map<String, Command> commands;
    private Display display;

    public ClubManagementCLI() {

        // Initialize system
        profileController = new ProfileController();
        scanner = new Scanner(System.in);
        user = new UserProfile();
        display = new WelcomeDisplay(this);

        commands = new HashMap<String, Command>();
        commands.put("1", new UpdatePersonalInfoCommand(user));

        // Log user into system
        //while (!login()) {} // For testing, comment out this line if you want to skip logging in!

        //displayDashboard(user);

        setDisplay(new WelcomeDisplay(this));

        while (true) {
            String userCommand = scanner.nextLine();

            if (display.getCommands().containsKey(userCommand)) {
                Command command = (Command) display.getCommands().get(userCommand);
                if (command instanceof LoginCommand) {
                    display.handleLoginCommand();
                } else if (command instanceof QuitCommand) {
                    display.handleQuitCommand();
                }
            } else {
                display.handleInvalidCommand();
            }


        }

        // while true
        //   get user input
        //   handle user input
        //     display.handleCommand


    }

    /**
     * Sets a new display.
     */
    public void setDisplay(Display display) {
        this.display.exit();
        this.display = display;
        this.display.enter();
    }

    /**
     * Sets the user for the system.
     */
    public void setUser(UserProfile user) {this.user = user;}

    /**
     * Prompts user for username and password. Logs user into system
     * if login attempt is valid.
     *
     * @return True if valid login attempt, false otherwise.
     *
     * @author Braeden Kloke
     */
    private boolean login() {
        String username, password;
        LoginController loginController = new LoginController();

        // Prompt user for username and password
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();

        // Authenticate user
        if (loginController.authenticate(username, password)) {
            System.out.println("User authenticated.");
            System.out.println("Logging in ...");
            user = profileController.getProfile(username);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Displays the system dashboard for a given user.
     *
     * @author Braeden Kloke
     */
    private void displayDashboard(UserProfile user) {
        System.out.println("Displaying " + user.getGroup() + " dashboard ...");
        System.out.println("=================================");
        System.out.println(user);

        // Print member commands
        System.out.println("=================================");
        System.out.println("Commands: ");
        System.out.println("1: update personal information");
        System.out.println("2: update fitness goals");
        System.out.println("3: update health metrics");
        System.out.println("4: schedule personal training session");
        System.out.println("5: schedule group fitness class");

        // Prompt member to enter a command
        System.out.println("=================================");
        System.out.println("Enter command: ");
        String command = scanner.nextLine();

        // if command is valid ...

        if (commands.containsKey(command)) {
            System.out.println("Valid command.");
            //((Command) commands.get(command)).execute();
        } else {
            System.out.println("Invalid command.");
        }
    }

}
