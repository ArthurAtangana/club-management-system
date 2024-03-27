package controllers;

import records.TrainerData;
import utils.UserDoesNotExistError;

import java.sql.*;

/**
 * Class representing a controller for performing operations on trainers
 * in the Club Management System database.
 *
 * @author Braeden Kloke
 * @version March 14, 2024
 */
public class TrainerController extends UserController {

    /**
     * Retrieves a trainer from the system.
     *
     * @param userIdentifier userId or email of the trainer.
     * @return Profile of the trainer.
     * @throws UserDoesNotExistError Thrown if the user does not exist.
     */
    public TrainerData getTrainer(String userIdentifier) throws UserDoesNotExistError {
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query;
        try {
            query = "SELECT * FROM trainers WHERE user_id=" + Integer.parseInt(userIdentifier) + ";";
        } catch (NumberFormatException e) {
            query = "SELECT * FROM trainers WHERE user_id=(SELECT user_id FROM users WHERE email='" + userIdentifier + "');";
        }
        TrainerData trainer;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                trainer = new TrainerData(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("trainer_id"),
                        resultSet.getInt("salary"));
            } else {
                throw new UserDoesNotExistError("Trainer", String.valueOf(userIdentifier));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trainer;
    }
}
