package backend.academy.gallow_game.service;

import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.utils.FileWordsManager;
import java.util.List;
import java.util.Random;

public class Randomizer {

    private final Random random = new Random();

    public String getRandomWord(int category, int diffLevel) throws WordNotFoundException {
        if (category == 6) category = random.nextInt(1, category);
        if (diffLevel == 4) diffLevel = random.nextInt(1, diffLevel);

        List<String> wordList = FileWordsManager.getWordList(category, diffLevel);

        return wordList.get(random.nextInt(wordList.size()));
    }
}
