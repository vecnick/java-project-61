package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConstants;
import hexlet.code.GameUtils;

public class Even {

    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void game() {
        GameRound[] rounds = new GameRound[GameConstants.COUNT_OF_GAMES];

        for (int i = 0; i < GameConstants.COUNT_OF_GAMES; i++) {
            rounds[i] = generateQuestion();
        }

        Engine.game(GAME_RULE, rounds);
    }

    private static GameRound generateQuestion() {
        int firstNumber = GameUtils.randomInt();

        return new GameRound(String.valueOf(firstNumber), findRightAnswer(firstNumber));
    }

    private static String findRightAnswer(int questionNumber) {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
