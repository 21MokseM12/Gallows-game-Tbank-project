package backend.academy.gallow_game.states;

import backend.academy.gallow_game.exceptions.DictionaryNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DictionaryStateTest {

    private final DictionaryStateManager stateManager = new DictionaryStateManager();

    @Test
    public void checkDictionaryCompletionSuccess() throws DictionaryNotFoundException {
        List<String> list = List.of("Ё","Й","Ц","У","К","Е","Н","Г","Ш","Щ","З","Х","Ъ","Ф","Ы","В","А","П","Р","О","Л","Д","Ж","Э","Я","Ч","С","М","И","Т","Ь","Б","Ю");
        stateManager.dictionaryCompletion();
        Assertions.assertEquals(list, stateManager.getCurrentDictionary());
    }

    @Test
    public void checkDictionaryCompletionDenied() {
        List<String> list = List.of("Ё","Й","Ц","У","К","Е","Н","Г","Ш","Щ","З","Х","Ъ","Ф","Ы","В","А","П","Р","О","Л","Д","Ж","Э","Я","Ч","С","М","И","Т","Ь","Б","Ю");
        Assertions.assertNotEquals(list, stateManager.getCurrentDictionary());
    }

    @Test
    public void checkDeleteLetterMethodSuccess() throws DictionaryNotFoundException {
        List<String> list = List.of("Ё","Й","Ц","У","К","Е","Н","Г","Щ","З","Х","Ъ","Ф","Ы","В","А","П","Р","О","Л","Д","Ж","Э","Я","Ч","С","М","И","Т","Ь","Б","Ю");
        stateManager.dictionaryCompletion();
        stateManager.deleteLetter("Ш");
        Assertions.assertEquals(list, stateManager.getCurrentDictionary());
    }

    @Test
    public void checkDeleteLetterMethodDenied() throws DictionaryNotFoundException {
        List<String> list = List.of("Ё","Й","Ц","У","К","Е","Н","Г","Ш","Щ","З","Х","Ъ","Ф","Ы","В","А","П","Р","О","Л","Д","Ж","Э","Я","Ч","С","М","И","Т","Ь","Б","Ю");
        stateManager.dictionaryCompletion();
        stateManager.deleteLetter("Ш");
        Assertions.assertNotEquals(list, stateManager.getCurrentDictionary());
    }
}
