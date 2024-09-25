package backend.academy.gallow_game.service;

import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.ui.enums.Logs;
import backend.academy.gallow_game.utils.GameFilesManager;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HintManager {

    @Getter private final String hint;

    private final String diffLevel;

    private final int easyHintFrontier = 7;

    private final int mediumHintFrontier = 5;

    private final int hardHintFrontier = 3;

    public HintManager(String category, String diffLevel, String word) {
        String s;
        try {
            s = GameFilesManager.getHint(category, diffLevel, word);
        } catch (WordNotFoundException e) {
            s = "Подсказка";
            log.error(Logs.WORD_NOT_FOUND_LOG.toString(), e);
        }
        this.hint = s;

        this.diffLevel = diffLevel;
    }

    public boolean isTimeToHint(int countFails) {
        return switch (diffLevel) {
            case "1" -> countFails <= easyHintFrontier;
            case "2" -> countFails <= mediumHintFrontier;
            case "3" -> countFails <= hardHintFrontier;
            default -> false;
        };

    }
}
