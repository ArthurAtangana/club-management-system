package main;

import main.models.*;
import main.views.*;

import java.util.*;

/**
 * Class representing the command line interface (CLI) for the
 * Health and Fitness Club Management System.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class ClubManagementCLI {

    private User user; // User logged into system
    private String userInput;
    private Object buffer; // Utility buffer
    private View view;

    public ClubManagementCLI() {

        // Initialize system
        Scanner scanner = new Scanner(System.in);
        user = new User();
        view = new HomeScreen(this);
        buffer = null;

        setView(new HomeScreen(this));

        while (true) {
            userInput = scanner.nextLine();

            if (view.hasCommands()) {
                handleUserCommand();
            } else {
                view.handleUserInput();
            }
        }
    }

    /**
     * Handles commands.
     */
    private void handleUserCommand() {
        if (view.getCommands().containsKey(userInput)) {
            Command command = (Command) view.getCommands().get(userInput);
            if (command.equals(Command.LOGIN)) {
                view.handleLoginCommand();
            } else if (command.equals(Command.QUIT)) {
                view.handleQuitCommand();
            }
        } else {
            view.handleInvalidCommand();
        }
    }

    /**
     * Sets a new display.
     */
    public void setView(View view) {
        this.view.exit();
        this.view = view;
        this.view.enter();
    }

    /**
     * Sets the user for the system.
     */
    public void setUser(User user) {this.user = user;}

    /**
     * Retrieves the most recent user of the system.
     */
    public User getUser() {return user;}

    /**
     * Puts in an object in the buffer.
     */
    public void setBuffer(Object obj) {buffer = obj;}

    /**
     * Retrieves the most recent user input.
     */
    public String getUserInput() {return userInput;}

    /**
     * Retrieves the contents of the buffer.
     */
    public Object getBuffer() {return buffer;}
}
