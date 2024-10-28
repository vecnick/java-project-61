package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    public static void game() {
        String userName = Engine.welcome();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

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

        return new GameQuestion(String.valueOf(firstNumber), isPrime(firstNumber) ? "yes" : "no");
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
