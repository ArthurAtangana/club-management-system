package main.views.commands;

import main.controllers.ProfileController;
import main.models.UserProfile;

public class UpdatePersonalInfoCommand implements Command {

    private UserProfile receiver;

    public UpdatePersonalInfoCommand(UserProfile user) {
        receiver = user;
    }

    public void execute() {
        ProfileController profileController = new ProfileController();

        UserProfile updatedProfile = new UserProfile();
        profileController.updateProfile(updatedProfile);
    }
}
