package main.models;

/**
 * Class representing a user's profile in the system.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class UserProfile {

    private String username;

    /**
     * Default constructor.
     */
    public UserProfile() {
        username = "braeden";
    }


    @Override
    public String toString() {
        return "username: " + username;

    }

    public String getUsername() {return username;}
}
