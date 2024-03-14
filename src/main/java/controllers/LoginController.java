package controllers;

/**
 * Class representing a controller to handle login requests.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 * Initialize interface and stub implementations.
 */
public class LoginController {

    /**
     * Default constructor
     */
    public LoginController() {
        // Expect there to be DB connection attributes here ...
    }

    /**
     * Authenticates a user of the system.
     *
     * @param username Name of user.
     * @param password User password.
     * @return True if user authenticated, false otherwise.
     */
    public boolean authenticate(String username, String password) {
        // THIS is where we will interact with the DB
        return true;
    }
}
