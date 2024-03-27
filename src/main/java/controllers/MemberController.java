package controllers;

import records.MemberData;
import utils.UserDoesNotExistError;

import java.sql.*;

/**
 * Class representing a controller for performing operations on members
 * in the Club Management System database.
 *
 * @author Braeden Kloke
 * @version March 14, 2024
 */
public class MemberController extends UserController {

    /**
     * Registers a new member in the system.
     *
     * @param firstName First name of new member.
     * @param lastName Last name of new member.
     * @param email Email of new member.
     * @param password Password for new member.
     */
    public void register(String firstName, String lastName, String email, String password) {
    }

    /**
     * Retrieves a member from the system.
     *
     * @param userIdentifier userId or email of the member.
     * @return Profile of member.
     * @throws UserDoesNotExistError Thrown if the user does not exist.
     */
    public MemberData getMember(String userIdentifier) throws UserDoesNotExistError {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query;
        try {
            query = "SELECT * FROM members WHERE user_id=" + Integer.parseInt(userIdentifier) + ";";
        } catch (NumberFormatException e) {
            query = "SELECT * FROM members WHERE user_id=(SELECT user_id FROM users WHERE email='" + userIdentifier + "');";
        }
        MemberData member;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                member = new MemberData(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("member_id"));
            } else {
                throw new UserDoesNotExistError("Member", String.valueOf(userIdentifier));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return member;
    }
}
