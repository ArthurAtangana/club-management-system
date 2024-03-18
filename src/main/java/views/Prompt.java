package views;

import ui.ClubManagementCLI;

/**
 * Class representing a user prompt for the Club Management CLI.
 *
 * @author Braeden Kloke
 * @version March 18, 2024
 */
public class Prompt extends View {

    private String prompt;
    private View nextView;

    public Prompt(ClubManagementCLI context, String prompt, View nextView) {
        super(context);
        this.prompt = prompt;
        this.nextView = nextView;
    }

    @Override
    public void printInfo() {
        System.out.print(prompt);
    }

    @Override
    public void handleUserInput() {
        // Transition to next view after receiving user input
        context.setView(nextView);
    }
}
