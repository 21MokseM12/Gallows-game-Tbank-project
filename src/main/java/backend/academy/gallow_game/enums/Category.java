package backend.academy.gallow_game.enums;

public enum Category {

    CITIES("Города", "cities"),

    CLOTHES("Одежда", "clothes"),

    EAT("Еда", "eat"),

    SPORT("Спорт", "sport"),

    TECHNIC("Техника и компьютеры", "technic");

    private final String categoryNameRU;

    private final String categoryNameEN;

    Category(String nameRU, String nameEN) {
        this.categoryNameRU = nameRU;
        this.categoryNameEN = nameEN;
    }

    public String getCategoryRU() {
        return this.categoryNameRU;
    }

    public String getCategoryEN() {
        return this.categoryNameEN;
    }
}
