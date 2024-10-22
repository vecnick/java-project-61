package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Nod {

    private static final int NUMBER_MAX = 100;

    public static GameResult game(Scanner scanner) {
        Random random = new Random();

        int firstNumber = random.nextInt(0, NUMBER_MAX);
        int secondNumber = random.nextInt(0, NUMBER_MAX);

        System.out.println("Question: " + firstNumber + " " + secondNumber);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();

        String rightAnswer = String.valueOf(mostCommonMultiple(firstNumber, secondNumber));

        return new GameResult(rightAnswer.equals(userAnswer), userAnswer, rightAnswer);
    }

    private static int mostCommonMultiple(int x, int y) {
        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x + y;
    }
}
