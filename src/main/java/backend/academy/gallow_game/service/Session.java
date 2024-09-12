package backend.academy.gallow_game.service;

import backend.academy.gallow_game.enums.GameState;
import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.interfaces.Validator;
import backend.academy.gallow_game.ui.UserInterface;
import backend.academy.gallow_game.utils.CategoryValidator;
import backend.academy.gallow_game.utils.DiffLevelValidator;
import lombok.Getter;

@Getter
public class Session {

    private final UserInterface ui = new UserInterface();

    private final Randomizer randomizer = new Randomizer();

    private final Validator categoryValidator = new CategoryValidator();

    private final Validator diffLevelValidator = new DiffLevelValidator();

    private final int COUNT_FAILS = 4;

    private final String DEFAULT_WORD = "Виселица";

    private String category;

    private String diffLevel;

    private GameState state = GameState.PLAY;

    public void start() {
        ui.clear();

        chooseCategory();
        chooseDiffLevel();

        String word = DEFAULT_WORD;
        try {
            word = randomizer.getRandomWord(Integer.parseInt(category), Integer.parseInt(diffLevel));
        } catch (WordNotFoundException _) {
            ui.getErrorMessage();
            System.exit(0);
        }

        ui.sessionBegin();
        ui.getMessageOfChosenCategory(Integer.parseInt(category));
        ui.getMessageOfChosenDiffLevel(Integer.parseInt(diffLevel));

        while (state.equals(GameState.PLAY)) {

        }

        if (state.equals(GameState.WIN)) {
            ui.getWinMessage();

        } else {
            ui.getLoseMessage();

        }
    }

    private void chooseCategory() {
        while (true) {
            ui.chooseCategory();
            ui.chooseMenuVariant();
            category = ui.read();
            ui.clear();

            if (categoryValidator.isValid(category)) break;
            else ui.getErrorMessage();
        }

        if (category.equals("6")) category = randomizer.getRandomCategory();
    }

    private void chooseDiffLevel() {
        while (true) {
            ui.chooseDifficultLevel();
            ui.chooseMenuVariant();
            diffLevel = ui.read();
            ui.clear();

            if (diffLevelValidator.isValid(diffLevel)) break;
            else ui.getErrorMessage();
        }

        if (diffLevel.equals("4")) diffLevel = randomizer.getRandomDiffLevel();
    }
}
