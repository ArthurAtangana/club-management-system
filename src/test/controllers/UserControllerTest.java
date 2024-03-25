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
    void beforeAll() {}// TODO: create test DB and add user

    @AfterAll
    void afterAll() {}// TODO: delete DB


    @Test
    void getUser() {
        // test getting a user from the database
        UserData dbUserData = userController.getUser("1");
        assertEquals(user.firstName(), dbUserData.firstName());
        assertEquals(user.lastName(), dbUserData.lastName());
        assertEquals(user.email(), dbUserData.email());
        assertEquals(user.password(), dbUserData.password());

        // test looking for a user that is not in the database
        UserData dbUserData2 = userController.getUser("999");
        assertNull(dbUserData2);
    }

    @Test
    void authenticate() {
        // success
        assertTrue(userController.authenticate("1", "password"));
        // wrong password
        assertFalse(userController.authenticate("1", "foo"));
        // user does not exist
        assertThrows(UserDoesNotExistError.class, () -> userController.authenticate("999", "password"));
    }
}