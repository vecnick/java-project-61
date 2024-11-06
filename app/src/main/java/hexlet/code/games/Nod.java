package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConstants;
import hexlet.code.GameUtils;

public class Nod {

    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void game() {
        GameRound[] rounds = new GameRound[GameConstants.COUNT_OF_GAMES];

        for (int i = 0; i < GameConstants.COUNT_OF_GAMES; i++) {
            rounds[i] = generateQuestion();
        }

        Engine.game(GAME_RULE, rounds);
    }

    private static GameRound generateQuestion() {
        int firstNumber = GameUtils.randomInt();
        int secondNumber = GameUtils.randomInt();

        String question = firstNumber + " " + secondNumber;

        return new GameRound(question, String.valueOf(findRightAnswer(firstNumber, secondNumber)));
    }

    private static int findRightAnswer(int x, int y) {
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
