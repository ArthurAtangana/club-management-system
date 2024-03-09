package main.views;

import main.ClubManagementCLI;
import main.views.commands.Command;

import java.util.*;

/**
 * Abstract class representing a display for the Health and Fitness
 * Club System's CLI.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public abstract class View {

    ClubManagementCLI context;
    Map<String, Command> commands;

    public View(ClubManagementCLI context) {
        this.context = context;
        commands = new HashMap<String, Command>();
    }

    /**
     * Prints this display's contents.
     */
    public void display() {}

    /**
     * Displays the commands the user can input.
     */
    public void displayCommands() {
        System.out.println("===============");
        System.out.println("Enter command: ");
        for (String key: commands.keySet()) {
            System.out.println(key + ": " + commands.get(key));
        }
    }

    /**
     * Retrieves the commands for this display.
     */
    public Map getCommands() {
        return commands;
    }

    /**
     * Returns true if this display has commands, false otherwise.
     */
    public boolean hasCommands() {return !commands.isEmpty();}


    /**
     * Action to be performed upon entering this display.
     */
    public void enter() {display();}

    /**
     * Action to be performed upon exiting this display.
     */
    public void exit() {}

    /**
     * Handles the event of an invalid command.
     */
    public void handleInvalidCommand() {}

    /**
     * Handles the event of a login command.
     */
    public void handleLoginCommand() {}

    /**
     * Handles the event of a quit command.
     */
    public void handleQuitCommand() {}

    /**
     * Handles the event of any user input.
     */
    public void handleUserInput() {}
}
