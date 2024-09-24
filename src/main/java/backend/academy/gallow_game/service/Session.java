package backend.academy.gallow_game.service;

import backend.academy.gallow_game.enums.GameState;
import backend.academy.gallow_game.exceptions.DictionaryNotFoundException;
import backend.academy.gallow_game.exceptions.GallowsStateNotFoundException;
import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.interfaces.Validator;
import backend.academy.gallow_game.states.DictionaryStateManager;
import backend.academy.gallow_game.states.WordStateManager;
import backend.academy.gallow_game.ui.UserInterface;
import backend.academy.gallow_game.ui.enums.Logs;
import backend.academy.gallow_game.utils.CategoryValidator;
import backend.academy.gallow_game.utils.DiffLevelValidator;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Session {

    private final UserInterface ui = new UserInterface();

    private final Randomizer randomizer = new Randomizer();

    private final DictionaryStateManager dictionary = new DictionaryStateManager();

    private final WordStateManager wordManager = new WordStateManager();

    private final Validator categoryValidator = new CategoryValidator();

    private final Validator diffLevelValidator = new DiffLevelValidator();

    @Getter private final int countFails = 10;

    private final String DEFAULT_WORD = "Виселица";

    private String category;

    private String diffLevel;

    private GameState state = GameState.PLAY;

    private int currentCountFails;

    public void start() {
        chooseCategory();
        chooseDiffLevel();

        String word = DEFAULT_WORD;
        try {
            word = randomizer.getRandomWord(category, diffLevel).toUpperCase();
            dictionary.dictionaryCompletion();
            wordManager.word(word);
            wordManager.correctWord(word);
            currentCountFails = countFails;
        } catch (WordNotFoundException | DictionaryNotFoundException e) {
            ui.getErrorMessage();
            log.error(Logs.IOEXCEPTION_WRAPPER_NOT_FOUND_LOG.toString(), e);
            System.exit(0);
        }
        HintManager hintManager = new HintManager(category, diffLevel, word);

        ui.sessionBegin();
        ui.getMessageOfChosenCategory(category);
        ui.getMessageOfChosenDiffLevel(diffLevel);

        while (state.equals(GameState.PLAY)) {
            try {
                ui.getCurrentGallowsState(countFails, currentCountFails);
            } catch (GallowsStateNotFoundException e) {
                ui.getErrorMessage();
                log.error(Logs.DISPLAY_FILE_NOT_FOUND_LOG.toString(), e);
                System.exit(0);
            }

            ui.getCurrentWordState(wordManager.getEncodedWord());
            if (hintManager.isTimeToHint(currentCountFails)) {
                ui.getHint(hintManager);
            }
            ui.getCurrentCountFails(currentCountFails);
            ui.getCurrentDictionaryState(dictionary);

            ui.chooseLetter();
            String letter = ui.read().toUpperCase();

            if (dictionary.deleteLetter(letter)) {
                if (wordManager.contains(letter)) {
                    ui.correctLetterChosen();
                    wordManager.changeLetter(letter);
                    if (wordManager.wordIsGuessed()) {
                        state = GameState.WIN;
                    }
                } else {
                    ui.wrongLetterChosen();
                    currentCountFails--;
                    if (currentCountFails == 0) {
                        state = GameState.LOSE;
                    }
                }
            } else {
                ui.wrongLetter();
            }
        }

        if (state.equals(GameState.WIN)) {
            ui.getWinMessage();
        } else {
            ui.getLoseMessage();
        }
        state = GameState.PLAY;

        try {
            ui.getCurrentGallowsState(countFails, currentCountFails);
            ui.getCurrentWordState(wordManager.correctWord());
        } catch (GallowsStateNotFoundException e) {
            ui.getErrorMessage();
            log.error(Logs.DISPLAY_FILE_NOT_FOUND_LOG.toString(), e);
            System.exit(0);
        }
    }

    private void chooseCategory() {
        while (true) {
            ui.chooseCategory();
            ui.chooseMenuVariant();
            category = ui.read();

            if (categoryValidator.isValid(category)) {
                break;
            } else {
                ui.getErrorMessage();
            }
        }

        if (category.equals("6")) {
            category = randomizer.getRandomCategory();
        }
    }

    private void chooseDiffLevel() {
        while (true) {
            ui.chooseDifficultLevel();
            ui.chooseMenuVariant();
            diffLevel = ui.read();

            if (diffLevelValidator.isValid(diffLevel)) {
                break;
            } else {
                ui.getErrorMessage();
            }
        }

        if (diffLevel.equals("4")) {
            diffLevel = randomizer.getRandomDiffLevel();
        }
    }
}
