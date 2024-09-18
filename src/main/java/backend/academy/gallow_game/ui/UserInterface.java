package backend.academy.gallow_game.ui;

import backend.academy.gallow_game.enums.Category;
import backend.academy.gallow_game.enums.DifficultLevel;
import backend.academy.gallow_game.exceptions.GallowsStateNotFoundException;
import backend.academy.gallow_game.states.WordStateManager;
import backend.academy.gallow_game.ui.enums.Messages;
import backend.academy.gallow_game.ui.service.UserDataManager;
import backend.academy.gallow_game.states.DictionaryStateManager;
import backend.academy.gallow_game.utils.GameFilesManager;

public class UserInterface {

    private final UserDataManager dataManager;

    public UserInterface() {
        this.dataManager = new UserDataManager();
    }

    public void getGreeting() {
        dataManager.write(Messages.GREETING.toString());
    }

    public void getMenu() {
        dataManager.write(Messages.MENU.toString());
    }

    public void chooseMenuVariant() {
        dataManager.write(Messages.CHOOSE_VARIANT.toString());
    }

    public void getRulesFormatted(final int countFails) {
        dataManager.write(Messages.RULES.toString().formatted(countFails));
    }

    public void getExitMessage() {
        dataManager.write(Messages.EXIT_MESSAGE.toString());
    }

    public void getErrorMessage() {
        dataManager.write(Messages.ERROR_MESSAGE.toString());
        dataManager.write("\n\n");
    }

    public void clear() {
        //TODO
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void chooseDifficultLevel() {
        dataManager.write(Messages.DIFFICULT_LEVEL_MESSAGE.toString());
    }

    public void chooseCategory() {
        dataManager.write(Messages.CATEGORY_MESSAGE.toString());
    }

    public void sessionBegin() {
        dataManager.write(Messages.GAME_BEGIN.toString());
        dataManager.write("\n");
    }

    public void getMessageOfChosenCategory(int category) {
        String message = Messages.CHOSEN_CATEGORY.toString();
        message = switch (category) {
            case 1 -> message.concat(Category.CITIES.getCategoryRU());
            case 2 -> message.concat(Category.CLOTHES.getCategoryRU());
            case 3 -> message.concat(Category.EAT.getCategoryRU());
            case 4 -> message.concat(Category.SPORT.getCategoryRU());
            case 5 -> message.concat(Category.TECHNIC.getCategoryRU());
            default -> message;
        };

        dataManager.write(message);
        dataManager.write("\n");
    }

    public void getMessageOfChosenDiffLevel(int diffLevel) {
        String message = Messages.CHOSEN_DIFF_LEVEL.toString();
        message = switch (diffLevel) {
            case 1 -> message.concat(DifficultLevel.EASY.getLevelName());
            case 2 -> message.concat(DifficultLevel.MEDIUM.getLevelName());
            case 3 -> message.concat(DifficultLevel.HARD.getLevelName());
            default -> message;
        };

        dataManager.write(message);
        dataManager.write("\n\n");
    }

    public void playAgainMessage() {
        dataManager.write("\n");
        dataManager.write(Messages.PLAY_AGAIN.toString());
    }

    public void getCurrentGallowsState(int countFails, int currentFails) throws GallowsStateNotFoundException {
        GameFilesManager.getGallowsStates(countFails - currentFails).forEach(System.out::println);
    }

    public void getCurrentDictionaryState(DictionaryStateManager dictionary) {
        dataManager.write(Messages.USABLE_LETTERS.toString());
        dictionary.getCurrentDictionary().stream().sorted().forEach(x -> System.out.print(x + " "));
        dataManager.write("\n");
    }

    public void getCurrentWordState(WordStateManager wordManager) {
        dataManager.write(Messages.CURRENT_WORD.toString());
        dataManager.write(wordManager.getEncodedWord());
        dataManager.write("\n");
    }

    public void getCurrentCountFails(int countFails) {
        dataManager.write(Messages.CURRENT_COUNT_FAILS.toString());
        dataManager.write(countFails + "\n");
    }

    public void chooseLetter() {
        dataManager.write(Messages.CHOOSE_LETTER.toString());
    }

    public void wrongLetter() {
        dataManager.write(Messages.WRONG_LETTER_ERROR.toString());
        dataManager.write("\n");
    }

    public void wrongLetterChosen() {
        dataManager.write(Messages.WRONG_LETTER_CHOSEN.toString());
        dataManager.write("\n\n");
    }

    public void correctLetterChosen() {
        dataManager.write(Messages.CORRECT_LETTER_CHOSEN.toString());
        dataManager.write("\n\n");
    }

    public void getWinMessage() {dataManager.write(Messages.WIN_MESSAGE.toString());}

    public void getLoseMessage() {dataManager.write(Messages.LOSE_MESSAGE.toString());}

    public String read() {
        return dataManager.read();
    }
}
