package backend.academy.gallow_game.exceptions;

public class DictionaryNotFoundException extends Throwable {

    public DictionaryNotFoundException(String message) {
        super(message);
    }

    public DictionaryNotFoundException(Throwable cause) {
        super(cause);
    }

    public DictionaryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
