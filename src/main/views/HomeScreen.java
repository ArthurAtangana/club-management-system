package main.views;

import main.ClubManagementCLI;
import main.views.commands.LoginCommand;

/**
 * Class representing the welcome display for the Health and Fitness
 * Club System's CLI.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class HomeScreen extends View {

    public HomeScreen(ClubManagementCLI context) {
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
        context.setDisplay(new HomeScreen(context));
    }

    @Override
    public void handleLoginCommand() {
        context.setDisplay(new UsernameLoginPrompt(context));
    }
}
