package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Please enter the game number and press Enter.
                2 - Even
                1 - Greet
                0 - Exit
                Your choice:\s""");
        String userChoice = scanner.next();
        System.out.println();
        
        switch (userChoice) {
            case "1" -> Cli.startApp();
            case "2" -> Even.game();
            default -> {}
        }
    }
}
