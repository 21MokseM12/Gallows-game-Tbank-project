package backend.academy.gallow_game.utils;

import backend.academy.gallow_game.exceptions.DictionaryNotFoundException;
import java.util.List;

public class Dictionary {

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
