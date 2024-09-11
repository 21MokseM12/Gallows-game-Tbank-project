package backend.academy.gallow_game.utils;

import backend.academy.gallow_game.interfaces.Validator;

public class CategoryValidator implements Validator {

    @Override
    public boolean isValid(String data) {
        return switch (data) {
            case "1", "2", "3", "4", "5", "6" -> true;
            default -> false;
        };
    }
}
