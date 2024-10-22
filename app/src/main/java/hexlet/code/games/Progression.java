package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression {

    private static final int NUMBER_MAX = 100;
    private static final int COUNT_OF_NUMBERS = 100;

    public static GameResult game(Scanner scanner) {
        Random random = new Random();

        int firstNumber = random.nextInt(0, NUMBER_MAX);
        int progressionStep = random.nextInt(0, NUMBER_MAX);
        int progressionMiss = random.nextInt(0, COUNT_OF_NUMBERS);

        int[] progression = new int[COUNT_OF_NUMBERS];
        progression[0] = firstNumber;

        for (int i = 1; i < COUNT_OF_NUMBERS; i++) {
            progression[i] = progression[i - 1] + progressionStep;
        }

        StringBuilder question = new StringBuilder();
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            question.append(" ");
            if (i != progressionMiss) {
                question.append(progression[i]);
            } else {
                question.append("..");
            }
        }

        System.out.println("Question:" + question);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();

        String rightAnswer = String.valueOf(progression[progressionMiss]);

        return new GameResult(rightAnswer.equals(userAnswer), userAnswer, rightAnswer);
    }
}
