package main.views;

import main.ClubManagementCLI;
import main.views.commands.QuitCommand;

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
        System.out.println("=================================");
        System.out.println(context.getUser());
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
