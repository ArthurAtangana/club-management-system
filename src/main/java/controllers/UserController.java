package controllers;

import Records.UserData;
import Utils.UserDoesNotExistError;

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
        String dbPassword;
        try {
            dbPassword = getUserPassword(Integer.parseInt(userId));
        } catch (UserDoesNotExistError e) {
            System.out.println(e.getMessage());
            return false;
        }
        return password.equals(dbPassword);
    }

    /**
     * Get a users password form the database.
     * @param userId Id of the user.
     * @return Password of the user.
     * @throws UserDoesNotExistError Thrown if the user does not exist.
     */
    private String getUserPassword(int userId) throws UserDoesNotExistError {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT password FROM users WHERE user_id=" + userId + ";";
        String password;
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                password = resultSet.getString("password");
            } else {
                throw new UserDoesNotExistError(userId);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return password;
    }
}
