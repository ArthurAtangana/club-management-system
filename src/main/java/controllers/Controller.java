package controllers;

import java.sql.*;

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
        url = "jdbc:postgresql://localhost:5432/assignment-3";
        username = "braedenkloke";
        password = "";
    }

    /**
     * Checks if database connection is healthy.
     *
     * @return True if database connection healthy.
     * @throws RuntimeException if database connection is unhealthy.
     */
    public boolean getHealth() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
