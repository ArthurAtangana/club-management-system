package main.controllers;

import main.models.User;

/**
 * Class representing a controller for retrieving and updating user profiles.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 * Initialize interface and stub implementations.
 */
public class UserController {

    public UserController() {}

    /**
     * Retrieves a given user's profile.
     *
     * @param username Name of user.
     * @return Profile of user.
     */
    public User getUser(String username) {
        return new User();
    }

    /**
     * Updates a given user's profile.
     *
     * @param newProfile New profile to replace current profile with.
     */
    public void updateUser(User newProfile) {
    }
}
