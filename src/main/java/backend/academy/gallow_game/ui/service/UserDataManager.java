package backend.academy.gallow_game.ui.service;

import java.util.Scanner;

@SuppressWarnings(value = "regexpsinglelinejava")
public class UserDataManager {

    private final Scanner input;

    public UserDataManager() {
        this.input = new Scanner(System.in);
    }

    public void write(String data) {
        System.out.print(data);
    }

    public String read() {
        return input.nextLine();
    }
}
