package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    public static void game() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        int counter = 0;
        do {
            int questionNumber = random.nextInt(0, Integer.MAX_VALUE);

            System.out.println("Question: " + questionNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals("yes") && questionNumber%2 == 0){
                System.out.println("Correct!");
                counter++;
            } else if (!userAnswer.equals("no")) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            } else if (questionNumber%2 == 1){
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            }

        } while (counter<3);
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
