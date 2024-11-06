package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Nod;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Welcome to the Brain Games!
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        String userChoice = scanner.next();
        System.out.println();

        switch (userChoice) {
            case "1" -> Cli.startApp();
            case "2" -> Even.game();
            case "3" -> Calc.game();
            case "4" -> Nod.game();
            case "5" -> Progression.game();
            case "6" -> Prime.game();
            default -> {
                scanner.close();
                return;
            }
        }

        scanner.close();
    }
}
