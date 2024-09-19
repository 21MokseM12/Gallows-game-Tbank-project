package backend.academy.gallow_game.exceptions;

public class WordNotFoundException extends Throwable {

    public WordNotFoundException(String message) {
        super(message);
    }

    public WordNotFoundException(Throwable cause) {
        super(cause);
    }

    public WordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
