package utils;

public class UserDoesNotExistError extends RuntimeException{
    public UserDoesNotExistError(String userType, String userIdentifier) {
        super(userType + " with the "+  getWhichIdentifier(userIdentifier) + " does not exist!");
    }

    private static String getWhichIdentifier(String userIdentifier) {
        try {
            return "user_id of " + Integer.parseInt(userIdentifier);
        } catch (NumberFormatException e) {
            return "email of " + userIdentifier;
        }
    }
}
