package controllers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import records.UserData;
import utils.UserDoesNotExistError;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    UserData user = new UserData(1, "John", "Smith", "john.smith@example.com", "password");
    UserController userController = new UserController();

    @BeforeAll
    static void beforeAll() {}// TODO: create test DB and add user

    @AfterAll
    static void afterAll() {}// TODO: delete DB


    @Test
    void getUser() {
        // test getting a user from the database
        UserData dbUserData = userController.getUser("1");
        assertEquals(user.firstName(), dbUserData.firstName());
        assertEquals(user.lastName(), dbUserData.lastName());
        assertEquals(user.email(), dbUserData.email());
        assertEquals(user.password(), dbUserData.password());

        // test looking for a user that is not in the database
        assertThrows(UserDoesNotExistError.class, () -> userController.getUser("999"));

        // test getting a user from the database by email
        UserData dbUserData3 = userController.getUser("john.smith@example.com");
        assertEquals(user.firstName(), dbUserData3.firstName());
        assertEquals(user.lastName(), dbUserData3.lastName());
        assertEquals(user.email(), dbUserData3.email());
        assertEquals(user.password(), dbUserData3.password());

        // test looking for a user that is not in the database by email
        assertThrows(UserDoesNotExistError.class, () -> userController.getUser("iNoExist"));
    }

    @Test
    void authenticate() {
        // success
        assertTrue(userController.authenticate("1", "password"));
        // wrong password
        assertFalse(userController.authenticate("1", "foo"));
        // user does not exist
        assertFalse(userController.authenticate("999", "password"));

        // authenticate with email instead of userId
        // success
        assertTrue(userController.authenticate("john.smith@example.com", "password"));
        // wrong password
        assertFalse(userController.authenticate("john.smith@example.com", "foo"));
        // user does not exist
        assertFalse(userController.authenticate("iNoExist", "password"));
    }
}