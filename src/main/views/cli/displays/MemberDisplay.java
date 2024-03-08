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
public class MemberDisplay extends Display {

    public MemberDisplay(ClubManagementCLI context) {
        super(context);
        commands.put("1", new QuitCommand());
    }

    @Override
    public void display() {
        System.out.println("Displaying member dashboard ...");
        displayCommands();
    }

    @Override
    public void handleInvalidCommand() {
        context.setDisplay(new MemberDisplay(context));
    }

    @Override
    public void handleQuitCommand() {
        context.setDisplay(new WelcomeDisplay(context));
    }
}
