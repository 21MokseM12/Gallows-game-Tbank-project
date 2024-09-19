package backend.academy.gallow_game.enums;

public enum DifficultLevel {

    EASY("Легкий", "easy.txt"), MEDIUM("Средний", "medium.txt"), HARD("Сложный", "hard.txt");

    private final String diffLevelName;

    private final String diffLevelFileName;

    DifficultLevel(String level, String fileName) {
        this.diffLevelName = level;
        this.diffLevelFileName = fileName;
    }

    public String getFileName() {
        return this.diffLevelFileName;
    }

    public String getLevelName() {
        return this.diffLevelName;
    }
}
