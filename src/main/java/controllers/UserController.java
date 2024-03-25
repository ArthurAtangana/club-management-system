package controllers;

import Records.UserData;

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
    public UserData getUser(String userId) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT * FROM users WHERE user_id=" + Integer.parseInt(userId) + ";";
        UserData user = null;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                user = new UserData(
                        resultSet.getInt("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            } else {
                System.out.println("user " + userId + " does not exist!");
            }
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
        // TODO: type check userId somewhere, probably not here
        System.out.println("UserId: " + userId);
        System.out.println("Given password: " + userId);
        System.out.println("DB password: " + getUserPassword(Integer.parseInt(userId)));
        System.out.println(password.equals(getUserPassword(Integer.parseInt(userId))));
        return password.equals(getUserPassword(Integer.parseInt(userId)));
    }

    private String getUserPassword(int userId) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT password FROM users WHERE user_id=" + userId + ";";
        String password;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                password = resultSet.getString("password");
            } else {
                System.out.println("user " + userId + " does not exist!");
                // TODO: create a user does not exist error
                throw new RuntimeException();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return password;
    }
}
