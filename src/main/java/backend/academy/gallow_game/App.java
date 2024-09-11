package backend.academy.gallow_game;

import backend.academy.gallow_game.service.Session;
import backend.academy.gallow_game.ui.UserInterface;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

    private static final UserInterface ui = new UserInterface();

    private static final Session session = new Session();

    private static boolean stopGameFlag = false;

    public static void main(String[] args) {
        ui.clear();
        ui.getGreeting();

        do {
            ui.getMenu();
            ui.chooseMenuVariant();

            String mainMenuResponse = ui.read();

            ui.clear();

            switch (mainMenuResponse) {
                case "1":
                    session.start();
                    break;
                case "2":
                    ui.getRulesFormatted(session.COUNT_FAILS());
                    ui.chooseMenuVariant();

                    String rulesMenuResponse = ui.read();

                    ui.clear();

                    switch (rulesMenuResponse) {
                        case "1":
                            session.start();
                            break;
                        case "2":
                            ui.getExitMessage();
                            stopGameFlag = true;
                            break;
                        default:
                            ui.getErrorMessage();
                            break;
                    }
                    break;
                case "3":
                    ui.getExitMessage();
                    stopGameFlag = true;
                    break;
                default:
                    ui.getErrorMessage();
                    break;
            }

            ui.playAgainMessage();
            ui.chooseMenuVariant();
            String anotherGameResponse = ui.read();

            if (anotherGameResponse.equals("2")) stopGameFlag = true;

        } while (!stopGameFlag);

        ui.getExitMessage();
    }
}
