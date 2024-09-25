package backend.academy.gallow_game.enums;

import java.util.NoSuchElementException;
import lombok.Getter;

@Getter
public enum DifficultLevel {

    EASY("Легкий", "easy.txt", "1", 7),

    MEDIUM("Средний", "medium.txt", "2", 5),

    HARD("Сложный", "hard.txt", "3", 3);

    private final String diffLevelName;

    private final String diffLevelFileName;

    private final String diffLevelMenuNum;

    private final int hintFrontier;

    DifficultLevel(String level, String fileName, String diffLevelMenuNum, int hintFrontier) {
        this.diffLevelName = level;
        this.diffLevelFileName = fileName;
        this.diffLevelMenuNum = diffLevelMenuNum;
        this.hintFrontier = hintFrontier;
    }

    public static DifficultLevel valueOfMenuNumber(String number) {
        return switch (number) {
            case "1" -> DifficultLevel.EASY;
            case "2" -> DifficultLevel.MEDIUM;
            case "3" -> DifficultLevel.HARD;
            default -> throw new NoSuchElementException();
        };
    }
}
