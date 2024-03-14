package controllers;

import models.User;

/**
 * Class representing a controller for retrieving and updating users in the system.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 * Initialize interface and stub implementations.
 */
public class UserController {

    public UserController() {
        // Expect there to be DB connection attributes here ...
    }

    /**
     * Retrieves a user from the system.
     *
     * @param username Name of user.
     * @return Profile of user.
     */
    public User getUser(String username) {
        // THIS is where we will interact with the DB
        return new User();
    }

    /**
     * Updates a user's profile in the system.
     *
     * @param newProfile New profile to replace current profile with.
     */
    public void updateUser(User newProfile) {
        // THIS is where we will interact with the DB
    }
}
