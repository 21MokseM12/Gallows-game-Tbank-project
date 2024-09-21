package backend.academy.gallow_game.ui;

import backend.academy.gallow_game.enums.Category;
import backend.academy.gallow_game.enums.DifficultLevel;
import backend.academy.gallow_game.exceptions.GallowsStateNotFoundException;
import backend.academy.gallow_game.states.DictionaryStateManager;
import backend.academy.gallow_game.states.WordStateManager;
import backend.academy.gallow_game.ui.enums.Messages;
import backend.academy.gallow_game.ui.service.UserDataManager;
import backend.academy.gallow_game.utils.GameFilesManager;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
        doubleNewLine();
    }

    public void clear() {
        //TODO
    }

    public void chooseDifficultLevel() {
        dataManager.write(Messages.DIFFICULT_LEVEL_MESSAGE.toString());
    }

    public void chooseCategory() {
        dataManager.write(Messages.CATEGORY_MESSAGE.toString());
    }

    public void sessionBegin() {
        dataManager.write(Messages.GAME_BEGIN.toString());
        newLine();
    }

    public void getMessageOfChosenCategory(String category) {
        String message = Messages.CHOSEN_CATEGORY.toString();
        message = switch (category) {
            case "1" -> message.concat(Category.CITIES.getCategoryRU());
            case "2" -> message.concat(Category.CLOTHES.getCategoryRU());
            case "3" -> message.concat(Category.EAT.getCategoryRU());
            case "4" -> message.concat(Category.SPORT.getCategoryRU());
            case "5" -> message.concat(Category.TECHNIC.getCategoryRU());
            default -> message;
        };

        dataManager.write(message);
        newLine();
    }

    public void getMessageOfChosenDiffLevel(String diffLevel) {
        String message = Messages.CHOSEN_DIFF_LEVEL.toString();
        message = switch (diffLevel) {
            case "1" -> message.concat(DifficultLevel.EASY.getLevelName());
            case "2" -> message.concat(DifficultLevel.MEDIUM.getLevelName());
            case "3" -> message.concat(DifficultLevel.HARD.getLevelName());
            default -> message;
        };

        dataManager.write(message);
        doubleNewLine();
    }

    public void playAgainMessage() {
        newLine();
        dataManager.write(Messages.PLAY_AGAIN.toString());
    }

    public void getCurrentGallowsState(int countFails, int currentFails) throws GallowsStateNotFoundException {
        newLine();
        GameFilesManager.getGallowsStates(countFails - currentFails).forEach(System.out::println);
        newLine();
    }

    public void getCurrentDictionaryState(DictionaryStateManager dictionary) {
        dataManager.write(Messages.USABLE_LETTERS.toString());
        dictionary.getCurrentDictionary().stream().sorted().forEach(x -> dataManager.write(x + " "));
        newLine();
    }

    public void getCurrentWordState(WordStateManager wordManager) {
        dataManager.write(Messages.CURRENT_WORD.toString());
        dataManager.write(wordManager.getEncodedWord());
        newLine();
    }

    public void getCurrentCountFails(int countFails) {
        dataManager.write(Messages.CURRENT_COUNT_FAILS.toString());
        dataManager.write(String.valueOf(countFails));
        newLine();
    }

    public void chooseLetter() {
        dataManager.write(Messages.CHOOSE_LETTER.toString());
    }

    public void wrongLetter() {
        dataManager.write(Messages.WRONG_LETTER_ERROR.toString());
        newLine();
    }

    public void wrongLetterChosen() {
        dataManager.write(Messages.WRONG_LETTER_CHOSEN.toString());
        doubleNewLine();
    }

    public void correctLetterChosen() {
        dataManager.write(Messages.CORRECT_LETTER_CHOSEN.toString());
        doubleNewLine();
    }

    public void getWinMessage() {
        dataManager.write(Messages.WIN_MESSAGE.toString());
    }

    public void getLoseMessage() {
        dataManager.write(Messages.LOSE_MESSAGE.toString());
    }

    public String read() {
        return dataManager.read();
    }

    private void newLine() {
        dataManager.write("\n");
    }

    private void doubleNewLine() {
        newLine();
        newLine();
    }
}
