package backend.academy.gallow_game.ui;

import backend.academy.gallow_game.ui.enums.Messages;
import backend.academy.gallow_game.ui.service.UserDataManager;

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

    public String read() {
        return dataManager.read();
    }
}
