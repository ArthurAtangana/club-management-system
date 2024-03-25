package controllers;

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
            PreparedStatement statement = connection.prepareStatement(userInsertQuery);
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,email);
            statement.setString(4,password);
            System.out.println(statement);
            int insertedRow = statement.executeUpdate();
            if (insertedRow > 0) {
                System.out.println("user registration successfull");
            } else {
                //TODO: create error and loop back
                System.out.println("email already registered");
                throw new RuntimeException();
            }
            // add user to member table
            PreparedStatement memberStatement = connection.prepareStatement(memberInsertQuery);
            memberStatement.setString(1,email);
            System.out.println(memberStatement);
            int insertedMemberRows = memberStatement.executeUpdate();
            if (insertedMemberRows > 0){
                System.out.println("member registered");
            } else {
                System.out.println("failed to add member in member table");
                throw new RuntimeException();
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}