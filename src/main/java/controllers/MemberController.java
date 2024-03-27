package controllers;

import org.postgresql.util.PSQLException;

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
    public boolean register(String firstName, String lastName, String email, String password) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String userInsertQuery = "INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?)";
        String memberInsertQuery = "INSERT INTO members (user_id) VALUES ((SELECT user_id FROM users WHERE email=?))";
        try {
            // add user to user table
            PreparedStatement userStatement = connection.prepareStatement(userInsertQuery);
            userStatement.setString(1,firstName);
            userStatement.setString(2,lastName);
            userStatement.setString(3,email);
            userStatement.setString(4,password);
            int insertedRow = userStatement.executeUpdate();
            if (insertedRow > 0) {
                System.out.println("User registration successful");
            } else {
                System.out.println("Failed to register user.");
                connection.close();
                return false;
            }
        } catch (SQLException e) {
            if (e instanceof PSQLException && e.getSQLState().equals("23505")) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                return false;
            } else {
                throw new RuntimeException(e);
            }
        }
        try {
            // add user to member table
            PreparedStatement memberStatement = connection.prepareStatement(memberInsertQuery);
            memberStatement.setString(1,email);
            int insertedMemberRows = memberStatement.executeUpdate();
            if (insertedMemberRows > 0){
                connection.close();
                return true;
            } else {
                System.out.println("Failed to add member in member table");
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}