package backend.academy.gallow_game.utils;

import backend.academy.gallow_game.interfaces.Validator;

public class DiffLevelValidator implements Validator {

    @Override
    public boolean isValid(String data) {
        return switch (data) {
            case "1", "2", "3", "4" -> true;
            default -> false;
        };
    }
}
