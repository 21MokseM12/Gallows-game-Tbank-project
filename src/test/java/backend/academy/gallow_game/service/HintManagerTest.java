package backend.academy.gallow_game.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HintManagerTest {

    @Test
    public void checkIsTimeToHintSuccess() {
        HintManager manager = new HintManager("1", "3", "Нефтекамск");
        Assertions.assertTrue(manager.isTimeToHint(2));
    }

    @Test
    public void checkIsTimeToHintDenied() {
        HintManager manager = new HintManager("1", "3", "Нефтекамск");
        Assertions.assertFalse(manager.isTimeToHint(8));
    }
}
