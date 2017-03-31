package leetcode.happyNumber;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example:&nbsp;19 is a happy number
 * 
 * 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * 
 * Credits:Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/happy-number/
 */
public class Solution {
    public boolean isHappy(int n) {
        for (Set<Integer> visited = new HashSet<Integer>(); visited.add(n); ) {
            int sumOfSquares = 0;
            for (; n > 0; n /= 10) {
                int digit = n % 10;
                sumOfSquares += digit * digit;
            }
            n = sumOfSquares;
        }
        return n == 1;
    }
}
