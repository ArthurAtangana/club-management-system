package Utils;

public class UserDoesNotExistError extends RuntimeException{
    public UserDoesNotExistError(int userId) {
        super("User " + userId + " does not exist!");
    }
}
