package ui;

import models.*;
import views.*;

import java.util.*;

/**
 * Class representing the command line interface (CLI) for the
 * Health and Fitness Club Management System.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class ClubManagementCLI {

    private User user; // User logged into system
    private String userInput;
    private Object buffer; // Utility buffer
    private View view;

    /**
     * Default constructor.
     */
    public ClubManagementCLI() {
        user = new User();
        view = null;
        buffer = null;
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
            userInput = scanner.nextLine();
            if (view.hasCommands()) {
                handleUserCommand();
            } else {
                view.handleUserInput();
            }
        }
    }

    private void handleUserCommand() {
        // Check if user command is valid
        if (view.getCommands().containsKey(userInput)) {
            // Check to see which command the user input
            Command command = (Command) view.getCommands().get(userInput);
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
    public void setUser(User user) {this.user = user;}

    /**
     * Retrieves the most recent user of the system.
     *
     * @return Most recent user of the system.
     */
    public User getUser() {return user;}

    /**
     * Retrieves the most recent user input.
     *
     * @return Most recent user input.
     */
    public String getUserInput() {return userInput;}

    /**
     * Puts an object in the buffer.
     *
     * @param obj Object to be put in the buffer.
     */
    public void setBuffer(Object obj) {buffer = obj;}

    /**
     * Retrieves the contents of the buffer.
     *
     * @return The contents of the buffer.
     */
    public Object getBuffer() {return buffer;}
}
