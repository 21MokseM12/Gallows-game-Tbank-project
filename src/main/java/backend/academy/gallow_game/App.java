package backend.academy.gallow_game;

import backend.academy.gallow_game.service.Session;
import backend.academy.gallow_game.ui.UserInterface;

@SuppressWarnings("uncommentedmain")
public final class App {

    private static final UserInterface UI = new UserInterface();

    private static final Session SESSION = new Session();

    private static boolean exitGameFlag = false;

    private static boolean exitRulesFlag = false;

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

                    while (!exitRulesFlag) {
                        UI.chooseMenuVariant();
                        String rulesMenuResponse = UI.read();

                        switch (rulesMenuResponse) {
                            case "1":
                                SESSION.start();
                                exitRulesFlag = true;
                                break;
                            case "2":
                                UI.getExitMessage();
                                exitRulesFlag = true;
                                exitGameFlag = true;
                                break;
                            default:
                                UI.getErrorMessage();
                                break;
                        }
                    }
                    break;
                case "3":
                    UI.getExitMessage();
                    exitGameFlag = true;
                    break;
                default:
                    UI.getErrorMessage();
                    break;
            }

            if (!exitGameFlag) {
                UI.playAgainMessage();
                UI.chooseMenuVariant();
                String anotherGameResponse = UI.read();

                if (anotherGameResponse.equals("2")) {
                    exitGameFlag = true;
                    UI.getExitMessage();
                } else {
                    exitRulesFlag = false;
                }
            }

        } while (!exitGameFlag);
    }
}
