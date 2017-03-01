package leetcode.guessNumberHigherorLower;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * 
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * 
 * 
 * Example:
 * 
 * n = 10, I pick 6.
 * 
 * Return 6.
 * 
 * 

 * Source: https://leetcode.com/problems/guess-number-higher-or-lower/
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        for (int start = 1, end = n;;) {
            int mid = start + ((end - start) >> 1);
            switch(guess(mid)) {
                case -1: end = mid; break;
                case  0: return mid;
                case +1: start = mid + 1; break;
            }
        }
    }
}
