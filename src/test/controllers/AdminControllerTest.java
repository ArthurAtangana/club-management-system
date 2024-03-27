package controllers;

import org.junit.jupiter.api.Test;
import records.AdminData;
import utils.UserDoesNotExistError;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    @Test
    void getAdmin() {
        AdminController adminController = new AdminController();

        AdminData member = adminController.getAdmin("1");
        assertEquals(1, member.adminId());
        assertEquals(1, member.userId());
        assertEquals(70000, member.salary());


        AdminData member2 = adminController.getAdmin("john.smith@example.com");
        assertEquals(1, member2.adminId());
        assertEquals(1, member2.userId());
        assertEquals(70000, member2.salary());

        assertThrows(UserDoesNotExistError.class, () -> adminController.getAdmin("999"));
        assertThrows(UserDoesNotExistError.class, () -> adminController.getAdmin("iNoExist"));
    }
}