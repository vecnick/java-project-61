package hexlet.code;

import java.util.Random;

public class GameUtils {

    private static final int NUMBER_MAX = 100;

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(0, NUMBER_MAX);
    }
}
