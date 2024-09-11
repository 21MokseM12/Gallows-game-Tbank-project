package backend.academy.gallow_game.ui.enums;

public enum Messages {

    GREETING("""

        "ВИСЕЛИЦА"

        Приветствую тебя, пользователь!
        """),

    MENU("""
        Ниже представлено меню, в котором ты можешь:

        1. Начать игру
        2. Узнать правила игры
        3. Выйти
        """),

    CHOOSE_VARIANT("Введи число, соответствующее нужному тебе варианту: "),

    RULES("""

        ПРАВИЛА ИГРЫ "ВИСЕЛИЦА"

        ПОДГОТОВКА:

        Пользователь выбирает уровень сложности, отвечающий за количество букв в загадываемом слове:
            легкий - 5 букв
            средний - 7 букв
            сложный - 10 букв

        НАЧАЛО ИГРЫ:

        Перед игроком появляется пустая виселица и прочерки, каждый прочерк соответствует одной букве загаданного слова.
        Игрок называет любую букву:
            если буква есть в загаданном слове - все прочерки, соответствующие этой букве в слове, заменяются на введенную букву;
            если буквы нет в загаданном слове -  дорисовывается один элемент виселицы.
        У игрока есть %s попыток, чтобы угадать слово, пока виселица не нарисована полностью.
        Игрок побеждает, когда все слово отгадано (все прочерки заменяются на буквы);
        Игрок проигрывает, когда виселица нарисована полностью.

        1. Начать игру
        2. Выйти
        %n"""
    ),

    EXIT_MESSAGE("До свидания!"),

    ERROR_MESSAGE("Что-то пошло не так, попробуйте еще раз или перезапустите программу."),

    CATEGORY_MESSAGE("""
        ВЫБЕРИТЕ КАТЕГОРИЮ:

        1. Города
        2. Одежда
        3. Еда
        4. Спорт
        5. Техника и компьютеры
        6. Случайная категория

        """),

    DIFFICULT_LEVEL_MESSAGE("""
        ВЫБЕРИТЕ УРОВЕНЬ СЛОЖНОСТИ:

        1. Легкий
        2. Средний
        3. Сложный
        4. Случайный уровень сложности

        """),

    PLAY_AGAIN("""
    Хотите сыграть еще раз?

    1. Да
    2. Нет
    """);

    private final String message;

    Messages (String message) {
        this.message = message;
    }

    public String toString() {return this.message;}
}
