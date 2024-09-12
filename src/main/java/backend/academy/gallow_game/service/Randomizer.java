package backend.academy.gallow_game.service;

import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.utils.FileWordsManager;
import java.util.List;
import java.util.Random;

public class Randomizer {

    private final Random random = new Random();

    public String getRandomWord(int category, int diffLevel) throws WordNotFoundException {
        List<String> wordList = FileWordsManager.getWordList(category, diffLevel);
        return wordList.get(random.nextInt(wordList.size()));
    }

    public String getRandomCategory() {
        return String.valueOf(random.nextInt(1, 6));
    }

    public String getRandomDiffLevel() {
        return String.valueOf(random.nextInt(1, 4));
    }
}
