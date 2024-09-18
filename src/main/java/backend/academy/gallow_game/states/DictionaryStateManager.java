package backend.academy.gallow_game.states;

import backend.academy.gallow_game.exceptions.DictionaryNotFoundException;
import backend.academy.gallow_game.utils.FileWordsManager;
import java.util.List;

public class DictionaryStateManager {

    private List<String> dictionary;

    public void dictionaryCompletion() throws DictionaryNotFoundException {
        dictionary = FileWordsManager.getDictionary();
    }

    public List<String> getCurrentDictionary() {
        return this.dictionary;
    }

    public boolean deleteLetter(String letter) {
        if (dictionary.contains(letter)) {
            dictionary.remove(letter);
            return true;
        } else return false;
    }
}
