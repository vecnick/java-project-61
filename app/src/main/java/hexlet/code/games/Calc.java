package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;
import hexlet.code.GameConstants;
import hexlet.code.GameUtils;

public class Calc {

    private static final String GAME_RULE = "What is the result of the expression?";
    private static final String[] OPERATIONS = {"+", "-", "*"};

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
        int secondNumber = GameUtils.randomInt();
        String operation = OPERATIONS[random.nextInt(0, 2)];

        String question = firstNumber + " " + operation + " " + secondNumber;

        return new GameRound(question, findRightAnswer(firstNumber, secondNumber, operation));
    }

    private static String findRightAnswer(int firstNumber, int secondNumber, String operation) {
        return switch (operation) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            default -> throw new Error("Unknown operation: " + operation + "!");
        };
    }
}
