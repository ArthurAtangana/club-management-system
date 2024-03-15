package controllers;

import models.User;

/**
 * Class representing a controller for performing general operations on users
 * in the Club Management System database. Users can be members, trainers or admin.
 *
 * @author Braeden Kloke
 * @version March 14, 2024
 */
public class UserController extends Controller {

    /**
     * Retrieves a user from the system.
     *
     * @param userId ID of user.
     * @return Profile of user.
     */
    public User getUser(String userId) {
        return new User();
    }

    /**
     * Authenticates a user of the system.
     *
     * @param userId ID of user.
     * @param password User password.
     * @return True if user authenticated, false otherwise.
     */
    public boolean authenticate(String userId, String password) {
        return true;
    }

    /**
     * Registers a new user in the system.
     *
     * @param firstName First name of new user.
     * @param password Password for new user.
     */
    public void register(String firstName, String password) {
    }
}
