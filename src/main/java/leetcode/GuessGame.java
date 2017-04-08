package leetcode;

import java.util.concurrent.ThreadLocalRandom;

/**
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 **/
public class GuessGame {
    private Integer guess = ThreadLocalRandom.current().nextInt();

    public int guess(int num) {
        return guess.compareTo(num);
    }
}
