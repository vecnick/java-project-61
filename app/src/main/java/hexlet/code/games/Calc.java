package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {

    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void game() {

        String userName = Engine.welcome();

        System.out.println("What is the result of the expression?");

        GameQuestion question1 = generateQuestion();
        GameQuestion question2 = generateQuestion();
        GameQuestion question3 = generateQuestion();

        Engine.game(userName,
                question1.question(), question1.rightAnswer(),
                question2.question(), question2.rightAnswer(),
                question3.question(), question3.rightAnswer());
    }

    private static GameQuestion generateQuestion() {
        Random random = new Random();

        int firstNumber = Engine.randomInt();
        int secondNumber = Engine.randomInt();
        String operation = OPERATIONS[random.nextInt(0, 2)];

        String question = firstNumber + " " + operation + " " + secondNumber;

        return new GameQuestion(question, findRightAnswer(firstNumber, secondNumber, operation));
    }

    private static String findRightAnswer(int firstNumber, int secondNumber, String operation) {
        return switch (operation) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            default -> "";
        };
    }
}
