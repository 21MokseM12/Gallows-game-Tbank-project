package backend.academy.gallow_game.enums;

import java.util.NoSuchElementException;
import lombok.Getter;

@Getter
public enum Category {

    CITIES("Города", "cities", "1"),

    CLOTHES("Одежда", "clothes", "2"),

    EAT("Еда", "eat", "3"),

    SPORT("Спорт", "sport", "4"),

    TECHNIC("Техника и компьютеры", "technic", "5");

    private final String categoryNameRU;

    private final String categoryNameEN;

    private final String categoryMenuNum;

    Category(String nameRU, String nameEN, String categoryMenuNum) {
        this.categoryNameRU = nameRU;
        this.categoryNameEN = nameEN;
        this.categoryMenuNum = categoryMenuNum;
    }

    public static Category valueOfMenuNumber(String number) {
        return switch (number) {
            case "1" -> Category.CITIES;
            case "2" -> Category.CLOTHES;
            case "3" -> Category.EAT;
            case "4" -> Category.SPORT;
            case "5" -> Category.TECHNIC;
            default -> throw new NoSuchElementException();
        };
    }
}
