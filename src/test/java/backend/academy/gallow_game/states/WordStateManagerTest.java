package backend.academy.gallow_game.states;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordStateManagerTest {

    private final WordStateManager stateManager = new WordStateManager();

    @Test
    public void checkWordIsGuessedSuccess() {
        stateManager.word("___");
        Assertions.assertTrue(stateManager.wordIsGuessed());
    }

    @Test
    public void checkWordIsGuessedDenied() {
        stateManager.word("__а");
        Assertions.assertFalse(stateManager.wordIsGuessed());
    }

    @Test
    public void checkEncodedWordShowSuccess() {
        stateManager.word("Виселица");
        stateManager.correctWord("Виселица");

        stateManager.changeLetter("и");
        Assertions.assertEquals("_и___и__", stateManager.getEncodedWord());
    }

    @Test
    public void checkEncodedWordShowDenied() {
        stateManager.word("Виселица");
        stateManager.correctWord("Виселица");

        stateManager.changeLetter("и");
        Assertions.assertNotEquals("_и___ица", stateManager.getEncodedWord());
    }

    @Test
    public void checkContainsLetterInWordSuccess() {
        stateManager.word("Виселица");
        Assertions.assertTrue(stateManager.contains("и"));
    }

    @Test
    public void checkContainsLetterInWordDenied() {
        stateManager.word("Виселица");
        Assertions.assertFalse(stateManager.contains("я"));
    }
}
