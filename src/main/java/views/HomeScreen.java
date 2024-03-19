package views;

import ui.ClubManagementCLI;

/**
 * Class representing the home screen for the Health and Fitness
 * Club System's CLI.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class HomeScreen extends View {

    /**
     * Parametric constructor.
     *
     * @param context CLI that this is a view of.
     */
    public HomeScreen(ClubManagementCLI context) {
        super(context);
        commands.put("1", Command.LOGIN);
        commands.put("2", Command.REGISTER);
    }

    @Override
    public void printInfo() {
        printLineBreak();
        System.out.println("Welcome! you are at the home screen for the Health and Fitness Club.");
    }

    @Override
    public void handleInvalidCommand() {
        context.setView(new HomeScreen(context));
    }

    @Override
    public void handleLoginCommand() {
        context.setView(new LoginView(context));
    }

    @Override
    public void handleRegisterCommand() {context.setView(new RegisterView(context));}
}
