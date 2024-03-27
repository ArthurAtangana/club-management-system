package utils;

public class UserDoesNotExistError extends RuntimeException{
    public UserDoesNotExistError(String userIdentifier) {
        super("User " + userIdentifier + " does not exist!");
    }
}
