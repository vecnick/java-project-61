package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression {

    public static GameResult game(Scanner scanner) {
        Random random = new Random();

        int firstNumber = random.nextInt(0, 100);
        int progressionStep = random.nextInt(0, 100);
        int progressionMiss = random.nextInt(0, 10);

        int[] progression = new int[10];
        progression[0] = firstNumber;

        for (int i=1; i<10; i++) {
            progression[i] = progression[i-1] + progressionStep;
        }

        StringBuilder question = new StringBuilder();
        for (int i=0; i<10; i++) {
            question.append(" ");
            if (i!=progressionMiss) {
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
