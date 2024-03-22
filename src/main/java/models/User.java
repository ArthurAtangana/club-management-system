package main.java.models;

import java.util.Collection;

/**
 * Class representing a user in the system.
 *
 * @author Braeden Kloke
 * @version March 8, 2024
 */
public class User {

    public enum Group {
        MEMBER,
        TRAINER,
        ADMIN
    }

    private String username;
    private Group group;
    private Collection<models.FitnessGoal> fitnessGoals;
    private Collection<models.HealthMetric> healthMetrics;


    /**
     * Default constructor.
     */
    public User() {
        username = "braeden";
        group = Group.MEMBER;
        fitnessGoals = null;
        healthMetrics = null;
    }

    /**
     * Default constructor.
     */
    public User(int user_id, String first_name, String last_name, String email, String password) {
        this.username = first_name + " " + last_name;
        group = Group.MEMBER;
        fitnessGoals = null;
        healthMetrics = null;
    }


    @Override
    public String toString() {
        return "username: " + username + "\n" +
                "fitness goals: " + fitnessGoals + "\n" +
                "health metrics: " + healthMetrics;

    }

    /**
     * Retrieves this user's name.
     *
     * @return Name of user.
     */
    public String getUsername() {return username;}

    /**
     * Retrieves this user's group.
     * Users can be a member, trainer or admin.
     *
     * @return Group this user belongs to.
     */
    public Group getGroup() {return group;}
}
