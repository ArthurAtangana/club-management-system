package controllers;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Abstract class representing a controller for accessing the
 * Club Management System database.
 *
 * @author Braeden
 * @version March 14, 2024
 */
public abstract class Controller {

    String databaseURL;
    String databaseUsername;
    String databasePassword;

    /**
     * Constructs a new Controller.
     */
    public Controller() {
        File configFile = new File("config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            databaseURL = props.getProperty("db.url");
            databaseUsername = props.getProperty("db.username");
            databasePassword = props.getProperty("db.password");

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if database connection is healthy.
     *
     * @return True if database connection healthy.
     * @throws RuntimeException if database connection is unhealthy.
     */
    public boolean getHealth() {
        try {
            Connection connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
