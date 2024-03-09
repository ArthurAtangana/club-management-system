package main;

import main.models.*;
import main.views.Command;
import main.views.View;
import main.views.HomeScreen;

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
    private View display;

    public ClubManagementCLI() {

        // Initialize system
        Scanner scanner = new Scanner(System.in);
        user = new User();
        display = new HomeScreen(this);
        buffer = null;


        setDisplay(new HomeScreen(this));

        while (true) {
            userInput = scanner.nextLine();

            if (display.hasCommands()) {
                handleUserCommand();
            } else {
                display.handleUserInput();
            }
        }
    }

    /**
     * Handles commands.
     */
    private void handleUserCommand() {
        if (display.getCommands().containsKey(userInput)) {
            Command command = (Command) display.getCommands().get(userInput);
            if (command.equals(Command.LOGIN)) {
                display.handleLoginCommand();
            } else if (command.equals(Command.QUIT)) {
                display.handleQuitCommand();
            }
        } else {
            display.handleInvalidCommand();
        }
    }

    /**
     * Sets a new display.
     */
    public void setDisplay(View display) {
        this.display.exit();
        this.display = display;
        this.display.enter();
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
