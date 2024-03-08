package main.controllers;

import main.models.UserProfile;

/**
 * Class representing a controller for retrieving and updating user profiles.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 * Initialize interface and stub implementations.
 */
public class ProfileController {

    public ProfileController() {}

    /**
     * Retrieves a given user's profile.
     *
     * @param username Name of user.
     * @return Profile of user.
     */
    public UserProfile getProfile(String username) {
        return new UserProfile();
    }

    /**
     * Updates a given user's profile.
     *
     * @param newProfile New profile to replace current profile with.
     */
    public void updateProfile(UserProfile newProfile) {
    }
}
