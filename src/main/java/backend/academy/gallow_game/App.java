package backend.academy.gallow_game;

import backend.academy.gallow_game.service.Session;
import backend.academy.gallow_game.ui.UserInterface;

@SuppressWarnings("uncommentedmain")
public final class App {

    private static final UserInterface UI = new UserInterface();

    private static final Session SESSION = new Session();

    private static boolean stopGameFlag = false;

    private App() {}

    public static void main(String[] args) {
        UI.getGreeting();

        do {
            UI.getMenu();
            UI.chooseMenuVariant();

            String mainMenuResponse = UI.read();

            switch (mainMenuResponse) {
                case "1":
                    SESSION.start();
                    break;
                case "2":
                    UI.getRulesFormatted(SESSION.countFails());
                    UI.chooseMenuVariant();

                    String rulesMenuResponse = UI.read();

                    switch (rulesMenuResponse) {
                        case "1":
                            SESSION.start();
                            break;
                        case "2":
                            UI.getExitMessage();
                            stopGameFlag = true;
                            break;
                        default:
                            UI.getErrorMessage();
                            break;
                    }
                    break;
                case "3":
                    UI.getExitMessage();
                    stopGameFlag = true;
                    break;
                default:
                    UI.getErrorMessage();
                    break;
            }

            if (!stopGameFlag) {
                UI.playAgainMessage();
                UI.chooseMenuVariant();
                String anotherGameResponse = UI.read();

                if (anotherGameResponse.equals("2")) {
                    stopGameFlag = true;
                }
            }

        } while (!stopGameFlag);

        UI.getExitMessage();
    }
}
