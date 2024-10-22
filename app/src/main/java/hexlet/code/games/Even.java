package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Even {

    public static GameResult game(Scanner scanner) {
        Random random = new Random();

        int questionNumber = random.nextInt(0, Integer.MAX_VALUE);

        System.out.println("Question: " + questionNumber);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();

        String rightAnswer = questionNumber % 2 == 0 ? "yes" : "no";

        return new GameResult(rightAnswer.equals(userAnswer), userAnswer, rightAnswer);
    }
}
