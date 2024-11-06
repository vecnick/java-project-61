package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConstants;
import hexlet.code.GameUtils;

import java.util.Random;

public class Progression {

    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final int COUNT_OF_NUMBERS = 10;

    public static void game() {
        GameRound[] rounds = new GameRound[3];

        for (int i = 0; i < GameConstants.COUNT_OF_GAMES; i++) {
            rounds[i] = generateQuestion();
        }

        Engine.game(GAME_RULE, rounds);
    }

    private static GameRound generateQuestion() {
        Random random = new Random();

        int firstNumber = GameUtils.randomInt();
        int progressionStep = GameUtils.randomInt();
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

        return new GameRound(question.toString(), String.valueOf(progression[progressionMiss]));
    }
}
