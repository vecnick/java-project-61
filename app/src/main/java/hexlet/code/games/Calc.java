package hexlet.code.games;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Calc {

    public static final Map<String, String> OPERATIONS_MAP = Map.of(
            "0", "+",
            "1", "-",
            "2", "*"
    );

    public static GameResult game(Scanner scanner) {
        Random random = new Random();

        int firstNumber = random.nextInt(0, 100);
        int secondNumber = random.nextInt(0, 100);
        String operation = OPERATIONS_MAP.get(String.valueOf(random.nextInt(0, 2)));

        System.out.println("Question: " + firstNumber + operation + secondNumber);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();

        String rightAnswer = switch (operation) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            default -> "";
        };

        return new GameResult(rightAnswer.equals(userAnswer), userAnswer, rightAnswer);
    }
}
