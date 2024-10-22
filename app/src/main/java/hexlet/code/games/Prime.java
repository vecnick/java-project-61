package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Prime {

    public static GameResult game(Scanner scanner) {
        Random random = new Random();

        int questionNumber = random.nextInt(0, Integer.MAX_VALUE);

        System.out.println("Question: " + questionNumber);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();

        String rightAnswer = isPrime(questionNumber) ? "yes" : "no";

        return new GameResult(rightAnswer.equals(userAnswer), userAnswer, rightAnswer);
    }

    public static boolean isPrime(Integer number) {
        if(number < 2) return false;
        for (int k = 2; k <= Math.sqrt(number); k++) {
            if (number % k == 0) {
                return false;
            }
        }
        return true;
    }
}
