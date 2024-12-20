package backend.academy.gallow_game.utils;

import backend.academy.gallow_game.enums.Category;
import backend.academy.gallow_game.enums.DifficultLevel;
import backend.academy.gallow_game.exceptions.DictionaryNotFoundException;
import backend.academy.gallow_game.exceptions.WordNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class GameFilesManagerTest {

    @Test
    public void checkSuccessListTest() throws WordNotFoundException {
        List<String> list = List.of("Прага", "Афины", "Керчь", "Минск", "Пекин", "Ханой", "Ухань", "Тверь", "Брест", "Псков");
        Assertions.assertEquals(list, GameFilesManager.getWordList(Category.CITIES, DifficultLevel.EASY));
    }

    @Test
    public void checkDeniedListTest() throws WordNotFoundException {
        List<String> list = List.of("Прага", "", "Керчь", "", "Пекин", "Hello, world!", "Ухань", "Тверь", "Брест", "Псков");
        Assertions.assertNotEquals(list, GameFilesManager.getWordList(Category.CITIES, DifficultLevel.EASY));
    }

    @Test
    public void checkSuccessDictionaryTest() throws DictionaryNotFoundException {
        List<String> list = List.of("Ё","Й","Ц","У","К","Е","Н","Г","Ш","Щ","З","Х","Ъ","Ф","Ы","В","А","П","Р","О","Л","Д","Ж","Э","Я","Ч","С","М","И","Т","Ь","Б","Ю");
        Assertions.assertEquals(list, GameFilesManager.getDictionary());
    }

    @Test
    public void checkDeniedDictionaryTest() throws DictionaryNotFoundException {
        List<String> list = new ArrayList<>();
        Assertions.assertNotEquals(list, GameFilesManager.getDictionary());
    }

    @Test
    public void checkSuccessHintTest() throws WordNotFoundException {
        Assertions.assertEquals("блюдо из мяса и подливы", GameFilesManager.getHint(Category.EAT, DifficultLevel.EASY, "Гуляш".toUpperCase()));
    }

    @Test
    public void checkDeniedHintTest() throws WordNotFoundException {
        Assertions.assertNotEquals("блюдо из мяса и подливы", GameFilesManager.getHint(Category.SPORT, DifficultLevel.EASY, "Спорт".toUpperCase()));
    }
}
