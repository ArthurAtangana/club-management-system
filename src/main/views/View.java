package main.views;

import main.ClubManagementCLI;

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
    public void printInfo() {}

    /**
     * Displays the commands the user can input.
     */
    public void printCommands() {
        if (hasCommands()) {
            printLineBreak();
            System.out.println("What would you like to do?");
            for (String key: commands.keySet()) {
                System.out.println(key + ": " + commands.get(key));
            }
        }
    }

    protected void printLineBreak() {
        System.out.println("=============================================");
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
    public void enter() {
        printInfo();
        printCommands();
    }

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

    public void handleRegisterCommand() {}
}
