package backend.academy.gallow_game.service;

import backend.academy.gallow_game.enums.Category;
import backend.academy.gallow_game.enums.DifficultLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HintManagerTest {

    @Test
    public void checkIsTimeToHintSuccess() {
        HintManager manager = new HintManager(Category.CITIES, DifficultLevel.HARD, "Нефтекамск".toUpperCase());
        Assertions.assertTrue(manager.isTimeToHint(2));
    }

    @Test
    public void checkIsTimeToHintDenied() {
        HintManager manager = new HintManager(Category.CITIES, DifficultLevel.HARD, "Нефтекамск".toUpperCase());
        Assertions.assertFalse(manager.isTimeToHint(8));
    }
}
