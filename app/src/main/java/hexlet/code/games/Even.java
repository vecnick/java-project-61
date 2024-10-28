package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void game() {

        String userName = Engine.welcome();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

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

        return new GameQuestion(String.valueOf(firstNumber), findRightAnswer(firstNumber));
    }

    private static String findRightAnswer(int questionNumber) {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
