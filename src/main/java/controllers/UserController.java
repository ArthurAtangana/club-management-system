package controllers;

import records.UserData;
import utils.UserDoesNotExistError;

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
     * @param userIdentifier userId or email of the user.
     * @return Profile of user.
     * @throws UserDoesNotExistError Thrown if the user does not exist.
     */
    public UserData getUser(String userIdentifier) throws UserDoesNotExistError {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query;
        try {
            query = "SELECT * FROM users WHERE user_id=" + Integer.parseInt(userIdentifier) + ";";
        } catch (NumberFormatException e) {
            query = "SELECT * FROM users WHERE email='" + userIdentifier + "';";
        }
        UserData user;
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
                throw new UserDoesNotExistError("User", String.valueOf(userIdentifier));
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
     * @param userIdentifier userId or email of the user.
     * @param password User password.
     * @return True if user authenticated, false otherwise.
     */
    public boolean authenticate(String userIdentifier, String password) {
        String dbPassword;
        try {
            dbPassword = getUserPassword(userIdentifier);
        } catch (UserDoesNotExistError e) {
            System.out.println(e.getMessage());
            return false;
        }
        return password.equals(dbPassword);
    }

    /**
     * Get a users password form the database.
     * @param userIdentifier userId or email of the user.
     * @return Password of the user.
     * @throws UserDoesNotExistError Thrown if the user does not exist.
     */
    private String getUserPassword(String userIdentifier) throws UserDoesNotExistError {
        return getUser(userIdentifier).password();
    }
}
