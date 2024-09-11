package backend.academy.gallow_game.utils;

import backend.academy.gallow_game.exceptions.WordNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FileWordsManagerTest {

    @Test
    public void checkSuccessListTest() throws WordNotFoundException {
        List<String> list = List.of("Прага", "Афины", "Керчь", "Минск", "Пекин", "Ханой", "Ухань", "Тверь", "Брест", "Псков");
        Assertions.assertEquals(list, FileWordsManager.getWordList(1,1));
    }

    @Test
    public void checkDeniedListTest() throws WordNotFoundException {
        List<String> list = List.of("Прага", "", "Керчь", "", "Пекин", "Hello, world!", "Ухань", "Тверь", "Брест", "Псков");
        Assertions.assertNotEquals(list, FileWordsManager.getWordList(1,1));
    }
}
