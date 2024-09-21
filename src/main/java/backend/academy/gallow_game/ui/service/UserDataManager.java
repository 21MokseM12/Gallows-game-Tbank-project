package backend.academy.gallow_game.ui.service;

import java.io.PrintStream;
import java.util.Scanner;

public class UserDataManager {

    private final Scanner input;

    public UserDataManager() {
        this.input = new Scanner(System.in);
    }

    public void write(String data) {
        PrintStream output = System.out;
        output.print(data);
    }

    public String read() {
        return input.nextLine();
    }
}
