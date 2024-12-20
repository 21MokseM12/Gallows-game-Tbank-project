package backend.academy.gallow_game.service;

import backend.academy.gallow_game.enums.Category;
import backend.academy.gallow_game.enums.DifficultLevel;
import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.utils.GameFilesManager;
import java.util.List;
import java.util.Random;

public class Randomizer {

    private final Random random = new Random();

    private static final int BEGIN_NUMBER_COUNTDOWN = 1;

    private static final int END_NUMBER_COUNTDOWN_CATEGORY = 6;

    private static final int END_NUMBER_COUNTDOWN_DIFF_LEVEL = 4;

    public String getRandomWord(Category category, DifficultLevel diffLevel) throws WordNotFoundException {
        List<String> wordList = GameFilesManager.getWordList(category, diffLevel);
        return wordList.get(random.nextInt(wordList.size()));
    }

    public Category getRandomCategory() {
        return Category.valueOfMenuNumber(
            String.valueOf(
                random.nextInt(BEGIN_NUMBER_COUNTDOWN, END_NUMBER_COUNTDOWN_CATEGORY)
            )
        );
    }

    public DifficultLevel getRandomDiffLevel() {
        return DifficultLevel.valueOfMenuNumber(
            String.valueOf(
                random.nextInt(BEGIN_NUMBER_COUNTDOWN, END_NUMBER_COUNTDOWN_DIFF_LEVEL)
            )
        );
    }
}
