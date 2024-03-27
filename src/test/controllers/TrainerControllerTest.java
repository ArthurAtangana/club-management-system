package controllers;

import org.junit.jupiter.api.Test;
import records.TrainerData;
import utils.UserDoesNotExistError;

import static org.junit.jupiter.api.Assertions.*;

class TrainerControllerTest {

    @Test
    void getTrainer() {
        TrainerController trainerController = new TrainerController();

        TrainerData member = trainerController.getTrainer("2");
        assertEquals(1, member.trainerId());
        assertEquals(2, member.userId());
        assertEquals(80000, member.salary());


        TrainerData member2 = trainerController.getTrainer("jane.doe@example.com");
        assertEquals(1, member2.trainerId());
        assertEquals(2, member2.userId());
        assertEquals(80000, member2.salary());

        assertThrows(UserDoesNotExistError.class, () -> trainerController.getTrainer("999"));
        assertThrows(UserDoesNotExistError.class, () -> trainerController.getTrainer("iNoExist"));
    }
}