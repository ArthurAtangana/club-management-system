package main.views;

import main.ClubManagementCLI;

/**
 * Class representing the welcome display for the Health and Fitness
 * Club System's CLI.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class MemberDashboard extends View {

    public MemberDashboard(ClubManagementCLI context) {
        super(context);
        commands.put("1", Command.QUIT);
    }

    @Override
    public void printInfo() {
        printLineBreak();
        System.out.println("Welcome " + context.getUser().getUsername() + "!");
        System.out.println();
        System.out.println(context.getUser());
        System.out.println();
    }

    @Override
    public void handleInvalidCommand() {
        context.setView(new MemberDashboard(context));
    }

    @Override
    public void handleQuitCommand() {
        context.setView(new HomeScreen(context));
    }
}
