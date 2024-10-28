package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    private static final int NUMBER_MAX = 100;

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(0, NUMBER_MAX);
    }

    public static String welcome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void game(String userName,
                            String question1,
                            String answer1,
                            String question2,
                            String answer2,
                            String question3,
                            String answer3) {
        Scanner scanner = new Scanner(System.in);

        String userAnswer1 = askQuestion(question1, scanner);
        if (answer1.equals(userAnswer1)) {
            System.out.println("Correct!");
        } else {
            finishGame(userAnswer1, answer1, userName);
            scanner.close();
            return;
        }

        String userAnswer2 = askQuestion(question2, scanner);
        if (answer2.equals(userAnswer2)) {
            System.out.println("Correct!");
        } else {
            finishGame(userAnswer2, answer2, userName);
            scanner.close();
            return;
        }

        String userAnswer3 = askQuestion(question3, scanner);
        if (answer3.equals(userAnswer3)) {
            System.out.println("Correct!");
        } else {
            finishGame(userAnswer3, answer3, userName);
            scanner.close();
            return;
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }

    public static String askQuestion(String question,
                                     Scanner scanner) {
        System.out.println("Question: " + question);

        System.out.print("Your answer: ");
        return scanner.next();
    }

    public static void finishGame(String userAnswer,
                                  String rightAnswer,
                                  String userName) {
        System.out.println("'" + userAnswer + "' is wrong answer "
                + ";(. Correct answer was '" + rightAnswer + "'.");

        System.out.println("Let's try again, " + userName + "!");
    }
}
