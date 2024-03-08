package main.views.cli.displays;

import main.views.cli.ClubManagementCLI;
import main.views.cli.commands.*;

/**
 * Class representing the welcome display for the Health and Fitness
 * Club System's CLI.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class WelcomeDisplay extends Display {

    public WelcomeDisplay(ClubManagementCLI context) {
        super(context);
        commands.put("1", new LoginCommand());
    }

    @Override
    public void display() {
        System.out.println("Welcome!");
        displayCommands();
    }

    @Override
    public void handleInvalidCommand() {
        context.setDisplay(new WelcomeDisplay(context));
    }

    @Override
    public void handleLoginCommand() {
        context.setDisplay(new LoginDisplay(context));
    }
}
