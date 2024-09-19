package backend.academy.gallow_game.ui.enums;

public enum Logs {

    IOEXCEPTION_WRAPPER_NOT_FOUND_LOG("Слово или словарь не были найдены"),

    DISPLAY_FILE_NOT_FOUND_LOG("Файл отображения не был найден"),

    WORD_NOT_FOUND_LOG("Слово не было найдено");

    private final String log;

    Logs(final String log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return this.log;
    }

}
