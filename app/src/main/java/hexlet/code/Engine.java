package hexlet.code;

import hexlet.code.games.*;

import java.util.*;
import java.util.function.Function;

public class Engine {

    public static final Map<String, Function<Scanner, GameResult>> ENGINE_MAP = Map.of(
            "2", Even::game,
            "3", Calc::game,
            "4", Nod::game,
            "5", Progression::game
    );

    public static final Map<String, String> RULES_MAP = Map.of(
            "2", "Answer 'yes' if the number is even, otherwise answer 'no'.",
            "3", "What is the result of the expression?",
            "4", "Find the greatest common divisor of given numbers.",
            "5", "What number is missing in the progression?"
    );

    public static void gameEngine(String gameNumber) {
        if (!ENGINE_MAP.containsKey(gameNumber) && !RULES_MAP.containsKey(gameNumber)) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(RULES_MAP.get(gameNumber));

        int counter = 0;
        do {
            GameResult result = ENGINE_MAP.get(gameNumber).apply(scanner);
            if (result.result()){
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'" + result.wrongAnswer() + "' is wrong answer " +
                        ";(. Correct answer was '" + result.rightAnswer() + "'.");
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
        } while (counter<3);
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
