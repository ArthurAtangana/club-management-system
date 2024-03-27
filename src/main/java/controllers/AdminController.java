package controllers;

import records.AdminData;
import utils.UserDoesNotExistError;

import java.sql.*;

/**
 * Class representing a controller for performing operations on administrators
 * in the Club Management System database.
 *
 * @author Braeden Kloke
 * @version March 14, 2024
 */
public class AdminController extends UserController {

    /**
     * Retrieves an admin from the system.
     *
     * @param userIdentifier userId or email of the admin.
     * @return Profile of the admin.
     * @throws UserDoesNotExistError Thrown if the user does not exist.
     */
    public AdminData getAdmin(String userIdentifier) throws UserDoesNotExistError {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query;
        try {
            query = "SELECT * FROM admins WHERE user_id=" + Integer.parseInt(userIdentifier) + ";";
        } catch (NumberFormatException e) {
            query = "SELECT * FROM admins WHERE user_id=(SELECT user_id FROM users WHERE email='" + userIdentifier + "');";
        }
        AdminData admin;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                admin = new AdminData(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("admin_id"),
                        resultSet.getInt("salary"));
            } else {
                throw new UserDoesNotExistError("Admin", String.valueOf(userIdentifier));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return admin;
    }
}
