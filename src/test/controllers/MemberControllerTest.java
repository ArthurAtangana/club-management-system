package controllers;

import org.junit.jupiter.api.Test;
import records.MemberData;
import utils.UserDoesNotExistError;

import static org.junit.jupiter.api.Assertions.*;

class MemberControllerTest {

    @Test
    void getMember() {
        MemberController memberController = new MemberController();

        MemberData member = memberController.getMember("3");
        assertEquals(1, member.memberId());
        assertEquals(3, member.userId());


        MemberData member2 = memberController.getMember("tom.black@example.com");
        assertEquals(1, member2.memberId());
        assertEquals(3, member2.userId());

        assertThrows(UserDoesNotExistError.class, () -> memberController.getMember("999"));
        assertThrows(UserDoesNotExistError.class, () -> memberController.getMember("iNoExist"));
    }
}