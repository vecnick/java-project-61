package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConstants;
import hexlet.code.GameUtils;

public class Prime {

    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void game() {
        GameRound[] rounds = new GameRound[GameConstants.COUNT_OF_GAMES];

        for (int i = 0; i < GameConstants.COUNT_OF_GAMES; i++) {
            rounds[i] = generateQuestion();
        }

        Engine.game(GAME_RULE, rounds);
    }

    private static GameRound generateQuestion() {
        int firstNumber = GameUtils.randomInt();

        return new GameRound(String.valueOf(firstNumber), isPrime(firstNumber) ? "yes" : "no");
    }

    public static boolean isPrime(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int k = 2; k <= Math.sqrt(number); k++) {
            if (number % k == 0) {
                return false;
            }
        }
        return true;
    }
}
