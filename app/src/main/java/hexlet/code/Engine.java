package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GameResult;
import hexlet.code.games.Nod;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;

public class Engine {

    private static final int COUNT_OF_TASKS = 3;

    private static final Map<String, Function<Scanner, GameResult>> ENGINE_MAP = Map.of(
            "2", Even::game,
            "3", Calc::game,
            "4", Nod::game,
            "5", Progression::game,
            "6", Prime::game
    );

    private static final Map<String, String> RULES_MAP = Map.of(
            "2", "Answer 'yes' if the number is even, otherwise answer 'no'.",
            "3", "What is the result of the expression?",
            "4", "Find the greatest common divisor of given numbers.",
            "5", "What number is missing in the progression?",
            "6", "Answer 'yes' if given number is prime. Otherwise answer 'no'."
    );

    public static void gameEngine(String gameNumber) {
        if (!Objects.equals(gameNumber, "1")
                && !ENGINE_MAP.containsKey(gameNumber)
                && !RULES_MAP.containsKey(gameNumber)) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        if (Objects.equals(gameNumber, "1")) {
            return;
        }

        System.out.println(RULES_MAP.get(gameNumber));

        int counter = 0;
        do {
            GameResult result = ENGINE_MAP.get(gameNumber).apply(scanner);
            if (result.result()) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'" + result.wrongAnswer() + "' is wrong answer "
                        + ";(. Correct answer was '" + result.rightAnswer() + "'.");
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
        } while (counter < COUNT_OF_TASKS);
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
