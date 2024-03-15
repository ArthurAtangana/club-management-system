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

    String url; // url of database
    String username; // username of database
    String password; // password of database

    /**
     * Constructs a new Controller.
     */
    public Controller() {
        File configFile = new File("config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");

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
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
