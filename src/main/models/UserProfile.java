package main.models;

import java.util.Collection;

/**
 * Class representing a user's profile in the system.
 *
 * @author Braeden Kloke
 * @version March 7, 2024
 */
public class UserProfile {

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
    public UserProfile() {
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

    public String getUsername() {return username;}

    public Group getGroup() {return group;}
}
