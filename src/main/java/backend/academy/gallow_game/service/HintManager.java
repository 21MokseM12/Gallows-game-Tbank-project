package backend.academy.gallow_game.service;

import backend.academy.gallow_game.exceptions.WordNotFoundException;
import backend.academy.gallow_game.utils.GameFilesManager;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class HintManager {

    private final String hint;

    private final String diffLevel;

    public HintManager(String category, String diffLevel, String word){
        String s;
        try {
            s = GameFilesManager.getHint(category, diffLevel, word);
        } catch (WordNotFoundException e) {
            s = "Подсказка";
            log.error("Подсказка не была найдена", e);
        }
        this.hint = s;

        this.diffLevel = diffLevel;
    }

    public boolean isTimeToHint(int countFails) {
        return switch (diffLevel) {
            case "1" -> countFails <= 7;
            case "2" -> countFails <= 5;
            case "3" -> countFails <= 3;
            default -> false;
        };

    }
}
