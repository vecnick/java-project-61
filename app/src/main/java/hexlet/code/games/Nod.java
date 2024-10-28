package hexlet.code.games;

import hexlet.code.Engine;

public class Nod {

    public static void game() {
        String userName = Engine.welcome();

        System.out.println("Find the greatest common divisor of given numbers.");

        GameQuestion question1 = generateQuestion();
        GameQuestion question2 = generateQuestion();
        GameQuestion question3 = generateQuestion();

        Engine.game(userName,
                question1.question(), question1.rightAnswer(),
                question2.question(), question2.rightAnswer(),
                question3.question(), question3.rightAnswer());
    }

    private static GameQuestion generateQuestion() {
        int firstNumber = Engine.randomInt();
        int secondNumber = Engine.randomInt();

        String question = firstNumber + " " + secondNumber;

        return new GameQuestion(question, String.valueOf(findRightAnswer(firstNumber, secondNumber)));
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
