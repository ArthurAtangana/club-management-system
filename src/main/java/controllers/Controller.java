package controllers;

/**
 * Abstract class representing a controller for accessing the
 * Club Management System database.
 *
 * @author Braeden
 * @version March 14, 2024
 */
public abstract class Controller {

    String url; // url of database
    String username; // username of database
    String password; // password of database

    /**
     * Constructs a new Controller.
     */
    public Controller() {
        url = "";
        username = "";
        password = "";
    }
}
