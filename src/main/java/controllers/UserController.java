package main.java.controllers;

import main.java.models.User;

import java.sql.*;

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
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT * FROM users WHERE user_id=" + userId + ";";
        User user = null;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("fist_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            } else {
                System.out.println("user " + userId + " does not exist!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
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
}
