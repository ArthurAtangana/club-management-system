package main.views;

import main.ClubManagementCLI;

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
        commands.put("1", Command.LOGIN);
    }

    @Override
    public void printInfo() {
        printLineBreak();
        System.out.println(
            """
            Welcome! you are at the home screen for the
            Health and Fitness Club.
        
            Where we put the HEALTH in fitness.
            """
        );
    }

    @Override
    public void handleInvalidCommand() {
        context.setView(new HomeScreen(context));
    }

    @Override
    public void handleLoginCommand() {
        context.setView(new UsernameLoginPrompt(context));
    }
}
