package views;

import controllers.MemberController;
import ui.ClubManagementCLI;

/**
 * Class representing the view when authenticating a user into the system.
 */
public class RegisteringMemberView extends View {

    public RegisteringMemberView(ClubManagementCLI context) {
        super(context);
    }

    @Override
    public void enter() {
        String firstName = context.getUserInput(3);
        String lastName = context.getUserInput(2);
        String email = context.getUserInput(1);
        String password = context.getUserInput(0);
        System.out.println("Registering new member ...");
        MemberController memberController = new MemberController();
        if (memberController.register(firstName,lastName,email,password)){
            System.out.println("New member registered.");
            context.setView(new HomeScreen(context));
        } else {
            System.out.println("Invalid email");
            context.setView(new HomeScreen(context));
        }
    }
}
