package hexlet.code;

import hexlet.code.games.GameRound;

import java.util.Scanner;

public class Engine {

    public static void game(String rule, GameRound[] rounds) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(rule);

        for (GameRound round : rounds) {
            System.out.println("Question: " + round.question());

            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (round.rightAnswer().equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer "
                        + ";(. Correct answer was '" + round.rightAnswer() + "'.");

                System.out.println("Let's try again, " + userName + "!");

                scanner.close();
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
