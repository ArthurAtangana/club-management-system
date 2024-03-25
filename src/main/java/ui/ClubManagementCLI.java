package ui;

import Records.UserData;
import views.*;

import java.util.*;

/**
 * Class representing the command line interface (CLI) for the
 * Health and Fitness Club Management System.
 *
 * @author Braeden Kloke
 * @version March 18, 2024
 */
public class ClubManagementCLI {

    private UserData user; // User logged into system
    private List<String> userInputs;
    private View view;


    /**
     * Default constructor.
     */
    public ClubManagementCLI() {
        user = new UserData(0, "foo", "bar", "baz", "password");
        view = null;
        userInputs = new LinkedList<String>();
    }

    /**
     * Starts the CLI.
     */
    public void start() {
        // Initialize objects
        Scanner scanner = new Scanner(System.in);
        setView(new HomeScreen(this)); // Initial view

        // Start CLI
        while (true) {
            userInputs.add(0, scanner.nextLine()); // keep history of user inputs
            if (view.hasCommands()) {
                handleUserCommand();
            } else {
                view.handleUserInput();
            }
        }
    }

    private void handleUserCommand() {
        // Check if user command is valid
        if (view.getCommands().containsKey(getMostRecentUserInput())) {
            // Check to see which command the user input
            Command command = (Command) view.getCommands().get(getMostRecentUserInput());
            if (command.equals(Command.LOGIN)) {
                view.handleLoginCommand();
            } else if (command.equals(Command.QUIT)) {
                view.handleQuitCommand();
            } else if (command.equals(Command.REGISTER)) {
                view.handleRegisterCommand();
            }
        } else {
            view.handleInvalidCommand();
        }
    }

    /**
     * Sets the view for this CLI.
     *
     * @param view View to be set.
     */
    public void setView(View view) {
        this.view = view;
        this.view.enter();
    }

    /**
     * Sets the current user of the system.
     * The current user is assumed to be logged in.
     *
     * @param user Current user.
     */
    public void setUser(UserData user) {this.user = user;}

    /**
     * Retrieves the most recent user of the system.
     *
     * @return Most recent user of the system.
     */
    public UserData getUser() {return user;}

    /**
     * Retrieves the most recent user input.
     *
     * @return Most recent user input.
     */
    public String getMostRecentUserInput() {return userInputs.get(0);}

    /**
     * Retrieves a user input from a given an index.
     *
     * @param index Index of the user input to retrieve.
     *              Index 0 is the most recent user input.
     * @return User input from the given index.
     */
    public String getUserInput(int index) {
        return userInputs.get(index);
    }
}
