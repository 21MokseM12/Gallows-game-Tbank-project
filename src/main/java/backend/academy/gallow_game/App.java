package backend.academy.gallow_game;

import backend.academy.gallow_game.ui.UserInterface;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

    private static final UserInterface ui = new UserInterface();

    private static boolean stopGameFlag = false;

    private static final int COUNT_FAILS = 4;

    public static void main(String[] args) {
        ui.getGreeting();

        do {
            ui.getMenu();
            ui.chooseMenuVariant();

            String mainMenuResponse = ui.read();

            switch (mainMenuResponse) {
                case "1":
                    startGame();
                    break;
                case "2":
                    ui.getRulesFormatted(COUNT_FAILS);
                    ui.chooseMenuVariant();

                    String rulesMenuResponse = ui.read();

                    switch (rulesMenuResponse) {
                        case "1":
                            startGame();
                            break;
                        case "2":
                            ui.getExitMessage();
                            stopGameFlag = true;
                            break;
                        default:
                            System.out.println("Неверно введены данные");
                            break;
                    }
                    break;
                case "3":
                    ui.getExitMessage();
                    stopGameFlag = true;
                    break;
                default:
                    System.out.println("Неверно введены данные");
                    break;
            }

        } while (!stopGameFlag);
    }

    private static void startGame() {

    }
}
