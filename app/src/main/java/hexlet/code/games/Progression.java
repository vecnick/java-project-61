package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {

    private static final int COUNT_OF_NUMBERS = 10;

    public static void game() {
        String userName = Engine.welcome();

        System.out.println("What number is missing in the progression?");

        GameQuestion question1 = generateQuestion();
        GameQuestion question2 = generateQuestion();
        GameQuestion question3 = generateQuestion();

        Engine.game(userName,
                question1.question(), question1.rightAnswer(),
                question2.question(), question2.rightAnswer(),
                question3.question(), question3.rightAnswer());
    }

    private static GameQuestion generateQuestion() {
        Random random = new Random();

        int firstNumber = Engine.randomInt();
        int progressionStep = Engine.randomInt();
        int progressionMiss = random.nextInt(0, COUNT_OF_NUMBERS - 1);

        int[] progression = new int[COUNT_OF_NUMBERS];
        progression[0] = firstNumber;

        for (int i = 1; i < COUNT_OF_NUMBERS; i++) {
            progression[i] = progression[i - 1] + progressionStep;
        }

        StringBuilder question = new StringBuilder();
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            if (i != 0) {
                question.append(" ");
            }

            if (i != progressionMiss) {
                question.append(progression[i]);
            } else {
                question.append("..");
            }
        }

        return new GameQuestion(question.toString(), String.valueOf(progression[progressionMiss]));
    }
}
