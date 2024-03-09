package main.models;

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
    private Collection<FitnessGoal> fitnessGoals;
    private Collection<HealthMetric> healthMetrics;


    /**
     * Default constructor.
     */
    public User() {
        username = "braeden";
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
